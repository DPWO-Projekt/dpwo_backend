package com.example.dpwo_backend.dataset.dto.datasetdistribution;

import com.example.dpwo_backend.dataset.model.datasetdistribution.Availability;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DatasetDistributionRequest {

    @NotBlank(message = "Url is required")
    private String url;

    @NotNull(message = "Availability is required")
    private Availability availability;

    @NotBlank(message = "Format is required")
    private String format;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
}
