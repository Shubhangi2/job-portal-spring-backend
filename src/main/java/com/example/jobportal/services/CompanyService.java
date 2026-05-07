package com.example.jobportal.services;

import com.example.jobportal.dto.company.CompanyRequestDto;
import com.example.jobportal.dto.company.CompanyResponseDto;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;

import java.util.List;

public interface CompanyService {
    public CompanyResponseDto createCompany(CompanyRequestDto request);
    public List<CompanyResponseDto> getCompanies();
}
