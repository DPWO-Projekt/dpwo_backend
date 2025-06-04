package com.example.dpwo_backend.catalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "catalogs")
public class Catalog {
    @Id
    private String id;
    private String title;
    private String description;
    private String parentCatalog; // In response, it will be a title of the parent catalog
    private List<String> subCatalogs; // List of sub-catalog ids
    private List<String> datasets; // List of dataset IDs
}
