package com.example.dpwo_backend.dto.dataset;

import com.example.dpwo_backend.model.LanguageSpecificDatasetInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class DatasetRequest {
    @Size(max = 100, message = "Theme cannot exceed 100 characters")
    private String theme;

    @NotEmpty(message = "Dataset should be defined for at least one language")
    private List<LanguageSpecificDatasetInfoRequest> datasetInfo;
}
