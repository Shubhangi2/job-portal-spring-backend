package com.example.jobportal.controller;


import com.example.jobportal.dto.ApiResponse;
import com.example.jobportal.dto.company.CompanyRequestDto;
import com.example.jobportal.dto.company.CompanyResponseDto;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;
import com.example.jobportal.jwt.JwtService;
import com.example.jobportal.services.CompanyService;
import com.example.jobportal.utils.AppRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @GetMapping("/companies")
    @PreAuthorize("hasAnyRole('"+ AppRoles.EMPLOYER+"','"+ AppRoles.ADMIN+"', '"+ AppRoles.JOBSEEKER+"')")
    public ResponseEntity<ApiResponse<List<CompanyResponseDto>>> getJobs() {
        return ResponseEntity.ok(ApiResponse.success(companyService.getCompanies()));
    }

    @PostMapping("/company")
    @PreAuthorize("hasAnyRole('"+ AppRoles.EMPLOYER+"','"+ AppRoles.ADMIN+"')")
    public ResponseEntity<ApiResponse<CompanyResponseDto>> createJob(@RequestBody CompanyRequestDto requestDto) {
        return ResponseEntity.ok(ApiResponse.created(companyService.createCompany(requestDto), "Job created successfully"));
    }
}
