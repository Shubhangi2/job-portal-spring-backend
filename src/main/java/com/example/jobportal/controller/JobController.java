package com.example.jobportal.controller;

import com.example.jobportal.dto.ApiResponse;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;
import com.example.jobportal.jwt.JwtService;
import com.example.jobportal.services.JobService;
import com.example.jobportal.services.UserService;
import com.example.jobportal.utils.AppRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @GetMapping("/jobs")
    @PreAuthorize("hasAnyRole('"+ AppRoles.EMPLOYER+"','"+ AppRoles.ADMIN+"', '"+ AppRoles.JOBSEEKER+"')")
    public ResponseEntity<ApiResponse<List<JobResponseDto>>> getJobs() {
        return ResponseEntity.ok(ApiResponse.success(jobService.getJobs()));
    }

    @PostMapping("/job")
    @PreAuthorize("hasAnyRole('"+ AppRoles.EMPLOYER+"','"+ AppRoles.ADMIN+"')")
    public ResponseEntity<ApiResponse<JobResponseDto>> createJob(@RequestBody JobRequestDto requestDto) {

        return ResponseEntity.ok(ApiResponse.created(jobService.createJob(requestDto), "Job created successfully"));
    }

}
