package com.example.dpwo_backend.dataset.repository;

import com.example.dpwo_backend.dataset.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DatasetRepository extends MongoRepository<Dataset, String> {
    List<Dataset> findByParentCatalog(String parentCatalog);
    List<Dataset> findByOwnerId(String ownerId);
}