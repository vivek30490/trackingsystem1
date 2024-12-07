package com.klu.jfsdproject;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.jfsd.Entries.CertificationUsers;

public interface UserRepository extends JpaRepository<CertificationUsers, Long> {
	 Optional<CertificationUsers> findByEmail(String email);
    boolean existsByEmail(String email);  // This method checks for the existence of an email
}
