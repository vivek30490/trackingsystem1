package com.klu.jfsdproject;


import org.springframework.stereotype.Service;
import com.klu.jfsd.Entries.CertificationUsers;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String email, String password) {
        // Find user by email
        Optional<CertificationUsers> userOptional = userRepository.findByEmail(email);
        
        // Check if user exists and passwords match
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
