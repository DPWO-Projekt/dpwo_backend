package com.example.dpwo_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class LanguageSpecificDatasetInfo {
    private String title;
    private String description;
    private List<String> keyword;
    private String langCode;
}
