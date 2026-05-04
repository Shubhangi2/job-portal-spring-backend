package com.example.jobportal.controller.public_routes;

import com.example.jobportal.dto.ApiResponse;
import com.example.jobportal.dto.LoginRequest;
import com.example.jobportal.dto.UserRequestDto;
import com.example.jobportal.dto.UserResponseDto;
import com.example.jobportal.jwt.JwtService;
import com.example.jobportal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;


    @PostMapping("/register")  // Fix 1: was "/auth/register" → duplicates the class-level "/auth" prefix, making it "/auth/auth/register"
    public ResponseEntity<ApiResponse<UserResponseDto>> registerUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponse = userService.registerUser(userRequestDto);

        UserDetails userDetails = userDetailsService.loadUserByUsername(userResponse.getId().toString());

        userResponse.setAccessToken(jwtService.generateAccessToken(userDetails, userResponse.getRole()));
        userResponse.setRefreshToken(jwtService.generateRefreshToken(userDetails, userResponse.getRole()));

        return ResponseEntity.ok(ApiResponse.created(userResponse, "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponseDto>> login(@RequestBody LoginRequest request) {
        userService.loginUser(request);
        UserResponseDto response = userService.loginUser(request);
        if(response == null){
            return ResponseEntity.ok(ApiResponse.error("Invalid user credentials", 200));
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(response.getId().toString());
        response.setAccessToken(jwtService.generateAccessToken(userDetails, response.getRole()));
        response.setRefreshToken(jwtService.generateRefreshToken(userDetails, response.getRole()));

        return ResponseEntity.ok(ApiResponse.success(response, "Login successful"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> body) { // Fix 3: uncommented — this is valid and useful, no reason to leave it out
        String refreshToken = body.get("refreshToken");
        String role = jwtService.extractRole(refreshToken);
        String id = jwtService.extractUsername(refreshToken);
        UserDetails user = userDetailsService.loadUserByUsername(id);

        if (jwtService.isTokenValid(refreshToken, user)) {
            return ResponseEntity.ok(Map.of(
                    "accessToken", jwtService.generateAccessToken(user, role)
            ));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}