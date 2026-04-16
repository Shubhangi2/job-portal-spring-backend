package com.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String email;
    private String phone;
    private String passwordHash;
    private String role;
    private boolean isUserActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
