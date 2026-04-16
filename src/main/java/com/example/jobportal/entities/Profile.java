package com.example.jobportal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String bio;
    private String highestEducation;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private Integer pincode;
    private String panno;
    private String resumeUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
