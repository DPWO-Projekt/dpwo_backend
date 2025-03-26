package com.example.dpwo_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "datasets")
public class Dataset {
    @Id
    private String id;
    private String theme;
    private List<LanguageSpecificDatasetInfo> languageSpecificDatasetInfos;
    private String schemaId;
}
