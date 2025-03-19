package com.example.dpwo_backend.dto.task;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
} 