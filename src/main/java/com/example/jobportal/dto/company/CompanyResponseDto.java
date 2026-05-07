package com.example.jobportal.dto.company;

import lombok.Data;

import java.security.Timestamp;

@Data
public class CompanyResponseDto {
    private Integer id;
    private Integer userId;
    private String name;
    private String gstNumber;
    private String location;
    private String description;
    private String websiteUrl;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
