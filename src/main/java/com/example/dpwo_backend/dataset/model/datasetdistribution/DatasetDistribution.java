package com.example.dpwo_backend.dataset.model.datasetdistribution;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "dataset_distributions")
public class DatasetDistribution {
    @Id
    private String id;
    private String datasetId;
    private String url;
    private Availability availability;
    private String format;
    private String title;
    private String description;
}
