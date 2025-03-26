package com.example.dpwo_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "language_specific_dataset_info")
public class LanguageSpecificDatasetInfo {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> keywords;
    private String languageCode;
}
