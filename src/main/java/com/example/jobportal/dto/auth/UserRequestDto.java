package com.example.jobportal.dto.auth;

import lombok.Data;

@Data
public class UserRequestDto {
    private String fullName;
    private String passwordHash;
    private String email;
    private String phone;
    private String role;

}
