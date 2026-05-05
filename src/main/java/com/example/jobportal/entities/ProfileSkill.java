package com.example.jobportal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
public class ProfileSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer profileId;
    private Integer skillId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
