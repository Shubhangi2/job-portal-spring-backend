package com.example.jobportal.dto.auth;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private boolean isUserActive;
    private String refreshToken;
    private String accessToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
