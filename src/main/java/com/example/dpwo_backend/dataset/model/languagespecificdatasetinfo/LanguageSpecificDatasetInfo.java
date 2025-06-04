package com.example.dpwo_backend.dataset.model.languagespecificdatasetinfo;

import lombok.Data;

import java.util.List;

@Data
public class LanguageSpecificDatasetInfo {
    private String title;
    private String description;
    private List<String> keyword;
    private String langCode;
}
