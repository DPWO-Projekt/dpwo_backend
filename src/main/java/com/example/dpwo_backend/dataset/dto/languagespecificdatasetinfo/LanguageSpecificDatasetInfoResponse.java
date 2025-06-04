package com.example.dpwo_backend.dataset.dto.languagespecificdatasetinfo;

import lombok.Data;
import java.util.List;

@Data
public class LanguageSpecificDatasetInfoResponse {
    private String title;
    private String description;
    private List<String> keyword;
    private String langCode;
} 