package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.auth.RegisterRequest;
import com.example.dpwo_backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public User toEntity(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        return user;
    }
} 