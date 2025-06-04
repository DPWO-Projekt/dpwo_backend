package com.example.dpwo_backend.catalog.dto;

import com.example.dpwo_backend.dataset.dto.DatasetResponse;
import lombok.Data;

import java.util.List;

@Data
public class CatalogResponse {
    private String id;
    private String title;
    private String description;
    private List<CatalogResponse> subCatalogs;
    private List<DatasetResponse> datasets;
    private String parentCatalog;
}
