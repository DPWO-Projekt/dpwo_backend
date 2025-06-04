package com.example.dpwo_backend.dataset.dto;

import com.example.dpwo_backend.dataset.dto.datasetdistribution.DatasetDistributionRequest;
import com.example.dpwo_backend.dataset.dto.languagespecificdatasetinfo.LanguageSpecificDatasetInfoRequest;
import com.example.dpwo_backend.dataset.dto.vcard.VCardRequest;
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

    private List<DatasetDistributionRequest> datasetDistributions;
}
