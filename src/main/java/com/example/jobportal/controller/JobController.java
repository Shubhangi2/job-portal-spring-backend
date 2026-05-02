package com.example.jobportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class JobController {

    @PostMapping("/jobs")
    public ResponseEntity<String> getJobs() {
        return ResponseEntity.ok("Jobs");
    }
}
