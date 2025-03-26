package com.example.dpwo_backend.dto.dataset;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SetSchemaRequest {
    @NotBlank(message = "Dataset id is required")
    private String id;

    @NotBlank(message = "Schema id is required")
    private String schemaId;
}
