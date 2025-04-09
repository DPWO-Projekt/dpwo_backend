package com.example.dpwo_backend.dto.dataset;

import com.example.dpwo_backend.model.LanguageSpecificDatasetInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class DatasetRequest {
    @Size(max = 100, message = "Theme cannot exceed 100 characters")
    private String theme;

    @NotBlank(message = "Uri is required")
    @Size(max = 100, message = "Uri cannot exceed 100 characters")
    private String uri;

    @NotEmpty(message = "Dataset should be defined for at least one language")
    private List<LanguageSpecificDatasetInfoRequest> languageSpecificDatasetInfo;

    private String schemaId;
    
    @JsonProperty("vCard")
    private VCardRequest vCard;
}
