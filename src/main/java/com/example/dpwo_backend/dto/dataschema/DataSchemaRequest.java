package com.example.dpwo_backend.dto.dataschema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Map;


@Data
public class DataSchemaRequest {
    @NotBlank(message = "Title is required")
    private String title;

    @NotEmpty(message = "At least one property is required")
    private Map<String, String> properties;

}
