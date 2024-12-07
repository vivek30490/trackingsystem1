package com.certificationdashboard;

import org.springframework.stereotype.Service;

import com.klu.jfsd.Entries.CertificationUsers;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

	private static CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }
    public static List<Certifications> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certifications addCertification(Certifications certification) {
        return certificationRepository.save(certification);
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }

    public Certifications updateCertification(Long id, Certifications certification) {
        Optional<Certifications> existingCert = certificationRepository.findById(id);
        if (existingCert.isPresent()) {
            Certifications certToUpdate = existingCert.get();
            certToUpdate.setName(certification.getName());
            certToUpdate.setOrganization(certification.getOrganization());
            certToUpdate.setStatus(certification.getStatus());
            certToUpdate.setObtained(certification.getObtained());
            certToUpdate.setExpires(certification.getExpires());
            certToUpdate.setTags(certification.getTags());
            return certificationRepository.save(certToUpdate);
        }
        return null;
    }
    
}