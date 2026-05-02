package com.example.jobportal.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserRequestDto {
    private String fullName;
    private String passwordHash;
    private String email;
    private String phone;
    private String role;

}
