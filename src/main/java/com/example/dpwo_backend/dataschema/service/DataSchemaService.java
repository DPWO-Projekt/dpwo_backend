package com.example.dpwo_backend.dataschema.service;


import com.example.dpwo_backend.dataschema.model.DataSchema;
import com.example.dpwo_backend.dataschema.repository.DataSchemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DataSchemaService {

    private final DataSchemaRepository dataSchemaRepository;

    public void createDataSchema(DataSchema dataSchema) {
        dataSchemaRepository.save(dataSchema);
    }

    public List<DataSchema> getDataSchemas() {
        return dataSchemaRepository.findAll();
    }

    public DataSchema getDataSchema(String id) {
        return dataSchemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data schema not found"));
    }
}
