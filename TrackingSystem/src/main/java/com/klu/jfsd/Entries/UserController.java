package com.klu.jfsd.Entries;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.jfsdproject.AuthenticationService;
import com.klu.jfsdproject.UserRepository;
import com.klu.jfsdproject.Userservice;
import com.klu.jfsd.Entries.CertificationUsers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your frontend
@RestController
@RequestMapping("/api") // This sets the base URL for the controller
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup") // Defines the /signup endpoint
    public ResponseEntity<String> signup(@RequestBody CertificationUsers user) {
        try {
            userRepository.save(user);
            return ResponseEntity.ok("User signed up successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already used email");
        }
    }
    @Autowired
    AuthenticationService authenticationService ;

    

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        
        if (isAuthenticated) {
            return ResponseEntity.ok("login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}

    


