package com.example.dpwo_backend.repository;

import com.example.dpwo_backend.model.DataSchema;
import com.example.dpwo_backend.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DataSchemaRepository extends MongoRepository<DataSchema, String> {

}

