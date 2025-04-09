package com.example.dpwo_backend.dto.dataschema;

import lombok.Data;

import java.util.Map;

@Data
public class DataSchemaResponse {
    private String id;
    private String name;
    private Map<String, String> properties;
}
