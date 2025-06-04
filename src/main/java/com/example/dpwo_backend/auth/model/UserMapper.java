package com.example.dpwo_backend.auth.model;

import com.example.dpwo_backend.auth.dto.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public User toEntity(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        return user;
    }
} 