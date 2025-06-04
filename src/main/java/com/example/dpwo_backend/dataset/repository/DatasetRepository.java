package com.example.dpwo_backend.dataset.repository;

import com.example.dpwo_backend.dataset.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatasetRepository extends MongoRepository<Dataset, String> {
    List<Dataset> findByOwnerId(String ownerId);
}
