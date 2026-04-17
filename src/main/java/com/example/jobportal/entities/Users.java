package com.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

    @PrePersist
    protected void onCreate() {
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        this.createdAt = Timestamp.valueOf(istTime.toLocalDateTime());
        this.updatedAt = Timestamp.valueOf(istTime.toLocalDateTime());
    }

    @PreUpdate
    protected void onUpdate() {
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        this.updatedAt = Timestamp.valueOf(istTime.toLocalDateTime());
    }
}
