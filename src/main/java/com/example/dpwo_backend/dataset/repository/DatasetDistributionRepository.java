package com.example.dpwo_backend.dataset.repository;

import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistribution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatasetDistributionRepository extends MongoRepository<DatasetDistribution, String> {
    List<DatasetDistribution> findByDatasetId(String datasetId);
} 