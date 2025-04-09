package com.example.dpwo_backend.dto.dataschema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;


@Data
public class DataSchemaRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotEmpty(message = "At least one property is required")
    private Map<String, String> properties;

}
