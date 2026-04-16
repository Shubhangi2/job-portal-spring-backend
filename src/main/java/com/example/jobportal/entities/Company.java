package com.example.jobportal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String name;
    private String gstNumber;
    private String location;
    private String description;
    private String websiteUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
