package com.example.dpwo_backend.dataset.repository;

import com.example.dpwo_backend.dataset.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatasetRepository extends MongoRepository<Dataset, String> {
}
