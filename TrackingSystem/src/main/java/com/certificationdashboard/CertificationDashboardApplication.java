package com.certificationdashboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.certificationdashboard") // Scan entities in the correct package
@EnableJpaRepositories("com.certificationdashboard") // Enable repository scanning in the correct package
public class CertificationDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificationDashboardApplication.class, args);
    }
}

