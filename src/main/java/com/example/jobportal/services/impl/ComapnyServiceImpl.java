package com.example.jobportal.services.impl;

import com.example.jobportal.dto.company.CompanyRequestDto;
import com.example.jobportal.dto.company.CompanyResponseDto;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;
import com.example.jobportal.entities.Company;
import com.example.jobportal.entities.Job;
import com.example.jobportal.repositories.CompanyRepository;
import com.example.jobportal.repositories.JobRepository;
import com.example.jobportal.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComapnyServiceImpl implements CompanyService {
    final CompanyRepository companyRepository;
    final ModelMapper modelMapper;


    @Override
    public CompanyResponseDto createCompany(CompanyRequestDto request) {
        Company company = modelMapper.map(request, Company.class);
        System.out.println("Job after mapping: " + company); // ← add this
        Company companyResult = companyRepository.save(company);
        return modelMapper.map(companyResult, CompanyResponseDto.class);
    }

    @Override
    public List<CompanyResponseDto> getCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(job -> modelMapper.map(job, CompanyResponseDto.class))
                .collect(Collectors.toList());
    }
}
