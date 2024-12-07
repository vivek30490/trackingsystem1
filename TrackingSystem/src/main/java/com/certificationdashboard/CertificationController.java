package com.certificationdashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // Allow requests from frontend
@RestController
@RequestMapping("/api/certifications") // Set base URL for certification endpoints
public class CertificationController {

    @Autowired
    private CertificationRepository certificationRepository;

    // Create a new certification
    @PostMapping
    public ResponseEntity<String> createCertification(@RequestBody Certifications certification) {
        try {
            certificationRepository.save(certification);
            return ResponseEntity.status(HttpStatus.CREATED).body("Certification created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating certification");
        }
    }

    // Get all certifications
    @GetMapping
    public List<Certifications> getAllCertifications() {
        // Fetch certifications from the database or service
        return CertificationService.getAllCertifications();
    }

    // Get certifications by status (Active, Expiring Soon, Expired)
    @GetMapping("/status/{status}")
    public List<Certifications> getCertificationsByStatus(@PathVariable String status) {
        return certificationRepository.findByStatus(status);
    }

    // Get certifications by organization
    @GetMapping("/organization/{organization}")
    public List<Certifications> getCertificationsByOrganization(@PathVariable String organization) {
        return certificationRepository.findByOrganization(organization);
    }

    // Get certifications by tags
    @GetMapping("/tags/{tag}")
    public List<Certifications> getCertificationsByTag(@PathVariable String tag) {
        return certificationRepository.findByTagsContaining(tag);
    }

    // Get a specific certification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Certifications> getCertificationById(@PathVariable Long id) {
        Optional<Certifications> certification = certificationRepository.findById(id);
        if (certification.isPresent()) {
            return ResponseEntity.ok(certification.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Update an existing certification
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCertification(@PathVariable Long id, @RequestBody Certifications certification) {
        if (certificationRepository.existsById(id)) {
            certification.setId(id);
            certificationRepository.save(certification);
            return ResponseEntity.ok("Certification updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certification not found");
        }
    }

    // Delete a certification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCertification(@PathVariable Long id) {
        if (certificationRepository.existsById(id)) {
            certificationRepository.deleteById(id);
            return ResponseEntity.ok("Certification deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Certification not found");
        }
    }
}

