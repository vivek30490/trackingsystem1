package com.klu.jfsdproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.jfsd.Entries.CertificationUsers;

@Service
public class Userservice {

    @Autowired
    private static UserRepository userRepository;

    public boolean registerUser(CertificationUsers user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // Email already exists
        }
        userRepository.save(user);
        return true;
    }

	


	




}
