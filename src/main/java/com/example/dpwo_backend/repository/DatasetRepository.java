package com.example.dpwo_backend.repository;

import com.example.dpwo_backend.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatasetRepository extends MongoRepository<Dataset, String> {
}
