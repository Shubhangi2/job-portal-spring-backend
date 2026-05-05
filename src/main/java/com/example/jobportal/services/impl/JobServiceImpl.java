package com.example.jobportal.services.impl;

import com.example.jobportal.dto.auth.UserRequestDto;
import com.example.jobportal.dto.jobs.JobRequestDto;
import com.example.jobportal.dto.jobs.JobResponseDto;
import com.example.jobportal.entities.Job;
import com.example.jobportal.repositories.JobRepository;
import com.example.jobportal.services.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    final JobRepository jobRepository;
    final ModelMapper modelMapper;
    @Override
    public JobResponseDto createJob(JobRequestDto request) {
        Job job = modelMapper.map(request, Job.class);
        System.out.println("Job after mapping: " + job); // ← add this
        Job jobResult = jobRepository.save(job);
        return modelMapper.map(jobResult, JobResponseDto.class);
    }
    @Override
    public List<JobResponseDto> getJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> modelMapper.map(job, JobResponseDto.class))
                .collect(Collectors.toList());
    }
}
