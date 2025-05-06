package com.example.dpwo_backend.dataschema.dto;

import lombok.Data;

import java.util.Map;

@Data
public class DataSchemaResponse {
    private String id;
    private String name;
    private Map<String, String> properties;
}
