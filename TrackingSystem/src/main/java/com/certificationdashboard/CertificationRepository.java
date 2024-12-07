package com.certificationdashboard;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CertificationRepository extends JpaRepository<Certifications, Long> {

	List<Certifications> findByStatus(String status);
    List<Certifications> findByOrganization(String organization);
    List<Certifications> findByTagsContaining(String tag);
}
