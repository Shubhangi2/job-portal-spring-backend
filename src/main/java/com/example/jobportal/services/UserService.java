package com.example.jobportal.services;

import com.example.jobportal.dto.auth.LoginRequest;
import com.example.jobportal.dto.auth.UserRequestDto;
import com.example.jobportal.dto.auth.UserResponseDto;

public interface UserService {
    public UserResponseDto registerUser(UserRequestDto userRequestDto);
    public UserResponseDto loginUser(LoginRequest request);
}
