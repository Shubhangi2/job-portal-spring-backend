package com.example.jobportal.dto.company;

import lombok.Data;

import java.security.Timestamp;

@Data
public class CompanyRequestDto {
    private Integer userId;
    private String name;
    private String gstNumber;
    private String location;
    private String description;
    private String websiteUrl;
}











