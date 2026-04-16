package com.example.jobportal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer jobId;
    private Integer userId;
    private String resumeUrl;
    private String coverLetter;
    private String experienceDuration;
    private String noticePeriodDuration;
    private String salaryExpectation;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
