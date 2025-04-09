package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataschema.DataSchemaRequest;
import com.example.dpwo_backend.dto.dataschema.DataSchemaResponse;
import com.example.dpwo_backend.model.DataSchema;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataSchemaMapper {

    public DataSchema toEntity(DataSchemaRequest dataSchemaDto) {
        DataSchema dataSchema = new DataSchema();
        dataSchema.setName(dataSchemaDto.getName());
        dataSchema.setProperties(dataSchemaDto.getProperties());
        return dataSchema;
    }

    public DataSchemaResponse toResponse(DataSchema dataSchema) {
        DataSchemaResponse response = new DataSchemaResponse();
        response.setId(dataSchema.getId());
        response.setName(dataSchema.getName());
        response.setProperties(dataSchema.getProperties());
        return response;
    }

    public List<DataSchemaResponse> toResponseList(List<DataSchema> dataSchemas) {
        return dataSchemas.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
