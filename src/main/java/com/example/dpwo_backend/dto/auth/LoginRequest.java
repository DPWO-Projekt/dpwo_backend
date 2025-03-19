package com.example.dpwo_backend.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    private String usernameOrEmail;
    
    @NotBlank(message = "Password is required")
    private String password;
} 