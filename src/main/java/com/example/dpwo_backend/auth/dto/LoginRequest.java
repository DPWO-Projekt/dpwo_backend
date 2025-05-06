package com.example.dpwo_backend.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    private String usernameOrEmail;
    
    @NotBlank(message = "Password is required")
    private String password;
} 