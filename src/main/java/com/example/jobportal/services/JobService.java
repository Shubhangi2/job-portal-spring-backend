package com.example.jobportal.services;

import com.example.jobportal.dto.auth.LoginRequest;
import com.example.jobportal.dto.auth.UserRequestDto;
import com.example.jobportal.dto.auth.UserResponseDto;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;

import java.util.List;

public interface JobService {
    public JobResponseDto createJob(JobRequestDto request);
    public List<JobResponseDto> getJobs();
}
