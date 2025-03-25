package com.example.dpwo_backend.service;


import com.example.dpwo_backend.model.DataSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.dpwo_backend.repository.DataSchemaRepository;


@Service
@RequiredArgsConstructor
public class DataSchemaService {

    private final DataSchemaRepository dataSchemaRepository;

    public void createDataSchema(DataSchema dataSchema) {
        dataSchemaRepository.save(dataSchema);
    }
}
