package com.example.jobportal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer companyId;
    private String postedBy;
    private String title;
    private String durationType;
    private String description;
    private String salaryRange;
    private String workLocation; //work from office/home/hybrid
    private String status;
    private Integer noOfOpenings;
    private String experienceRequired;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
