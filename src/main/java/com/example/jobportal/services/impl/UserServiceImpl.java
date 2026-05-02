package com.example.jobportal.services.impl;

import com.example.jobportal.dto.LoginRequest;
import com.example.jobportal.dto.UserRequestDto;
import com.example.jobportal.dto.UserResponseDto;
import com.example.jobportal.entities.Users;
import com.example.jobportal.jwt.JwtService;
import com.example.jobportal.repositories.UserRepository;
import com.example.jobportal.services.UserService;
import jakarta.annotation.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    final UserRepository userRepository;
    final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, JwtService jwtService) {
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

    @Override
    @Nullable
    public UserResponseDto loginUser(LoginRequest request) {
        Users user = userRepository.findById(request.getUserId())
                .orElse(null);
        if (user == null) {
            return null;
        }
        if(!Objects.equals(user.getPassword(), request.getPassword())){
            return null;
        }

        System.out.println(user);
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
