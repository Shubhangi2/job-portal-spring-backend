package com.example.jobportal.dto.jobs;

import lombok.Data;

@Data
public class JobRequestDto {
    private Integer companyId;
    private String postedBy;
    private String title;
    private String durationType;
    private String description;
    private String salaryRange;
    private String workLocation;
    private String status;
    private Integer noOfOpenings;
    private String experienceRequired;
}











