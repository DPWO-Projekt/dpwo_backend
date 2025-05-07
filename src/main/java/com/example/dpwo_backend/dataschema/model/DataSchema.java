package com.example.dpwo_backend.dataschema.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Data
@Document(collection = "data_schemas")
public class DataSchema {
    @Id
    private String id;
    private String name;
    private Map<String, String> properties;
}