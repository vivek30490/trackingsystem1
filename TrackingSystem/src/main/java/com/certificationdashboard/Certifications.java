package com.certificationdashboard;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "certifications_table")  // Specify the table name (optional, defaults to the class name)
public class Certifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    @Column(name = "name", nullable = false)
    private String name;  // Certification name

    @Column(name = "organization", nullable = false)
    private String organization;  // Organization offering the certification

    @Column(name = "status", nullable = false)
    private String status;  // Status (Active, Expiring Soon, Expired)

    @Column(name = "obtained_date", nullable = false)
    private String obtained;  // Date when certification was obtained

    @Column(name = "expires_date", nullable = false)
    private String expires;  // Date when certification expires
    
    @ElementCollection
    @Column(name = "tag")
    private List<String> tags;  // List of tags for the certification

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObtained() {
        return obtained;
    }

    public void setObtained(String obtained) {
        this.obtained = obtained;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
