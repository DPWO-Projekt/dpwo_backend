package com.example.dpwo_backend.dataschema.repository;

import com.example.dpwo_backend.dataschema.model.DataSchema;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataSchemaRepository extends MongoRepository<DataSchema, String> {

}

