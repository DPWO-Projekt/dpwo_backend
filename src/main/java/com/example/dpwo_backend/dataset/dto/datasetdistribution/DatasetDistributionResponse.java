package com.example.dpwo_backend.dataset.dto.datasetdistribution;

import com.example.dpwo_backend.dataset.model.datasetdistribution.Availability;
import lombok.Data;

@Data
public class DatasetDistributionResponse {
    private String id;
    private String url;
    private Availability availability;
    private String format;
    private String title;
    private String description;
}
