package com.klu.jfsd.Entries;



import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_table")
public class CertificationUsers {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private Long userId;

	    
		@Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;
	    @Enumerated(EnumType.STRING)
	    @Column(name = "role", nullable = false)
	    private Role role;
	    
	    @Column(name = "password", nullable = false)
	    private String password;

	    
	    
	    public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}


		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		
	    public enum Role {
	        USER, ADMIN
	    }
	     
	    @JsonCreator
	    public static Role fromValue(String value) {
	        try {
	            return Role.valueOf(value.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            throw new RuntimeException("Invalid role: " + value);
	        }
	    }
	   
	}


