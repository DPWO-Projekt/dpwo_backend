package com.example.dpwo_backend.dataset.dto;

import lombok.Data;
import java.util.List;

@Data
public class DatasetListResponse {
    private List<DatasetListItem> datasets;
    
    @Data
    public static class DatasetListItem {
        private String id;
        private String uri;
        private String theme;
        private String title; // Will be taken from languageSpecificDatasetInfo
        private String description; // Will be taken from languageSpecificDatasetInfo
    }
} 