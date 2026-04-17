package com.example.jobportal.services.impl;

import com.example.jobportal.dto.UserRequestDto;
import com.example.jobportal.dto.UserResponseDto;
import com.example.jobportal.entities.Users;
import com.example.jobportal.repositories.UserRepository;
import com.example.jobportal.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;
    final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        Users user = modelMapper.map(userRequestDto, Users.class);
        user.setUserActive(true);
        
        Users savedUser = userRepository.save(user);
        
        return modelMapper.map(savedUser, UserResponseDto.class);
    }
}
