package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataschema.DataSchemaRequest;
import com.example.dpwo_backend.model.DataSchema;
import org.springframework.stereotype.Component;

@Component
public class DataSchemaMapper {

    public DataSchema toEntity(DataSchemaRequest dataSchemaDto) {
        DataSchema dataSchema = new DataSchema();
        dataSchema.setTitle(dataSchemaDto.getTitle());
        dataSchema.setProperties(dataSchemaDto.getProperties());
        return dataSchema;
    }

}
