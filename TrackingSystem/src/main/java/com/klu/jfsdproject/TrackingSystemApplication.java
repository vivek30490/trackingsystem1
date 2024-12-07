package com.klu.jfsdproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.klu.jfsdproject") 
@EntityScan("com.klu.jfsd.Entries")   

@ComponentScan(basePackages = "com.klu.jfsdproject") 
@ComponentScan(basePackages = {"com.klu.jfsd.Entries"})

public class TrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackingSystemApplication.class, args);
	}

}
