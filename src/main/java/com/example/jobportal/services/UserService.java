package com.example.jobportal.services;

import com.example.jobportal.dto.UserRequestDto;
import com.example.jobportal.dto.UserResponseDto;

public interface UserService {
    public UserResponseDto registerUser(UserRequestDto userRequestDto);
}
