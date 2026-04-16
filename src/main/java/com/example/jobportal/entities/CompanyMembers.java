package com.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
public class CompanyMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer companyId;
    private String role;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
