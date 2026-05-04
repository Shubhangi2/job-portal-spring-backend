package com.example.jobportal.controller.jobseeker;

import com.example.jobportal.jwt.JwtService;
import com.example.jobportal.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request/jobseeker")
@RequiredArgsConstructor
public class JsJobController {
    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/jobs")
    public ResponseEntity<String> getJobs() {
        System.out.println("inside controller");
        UserDetails userDetails = userDetailsService.loadUserByUsername("1");
        return ResponseEntity.ok("Jobs");
    }


}
