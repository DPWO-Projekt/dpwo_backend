package com.example.dpwo_backend.dataset.service;

import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistribution;
import com.example.dpwo_backend.dataset.repository.DatasetDistributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatasetDistributionService {
    private final DatasetDistributionRepository distributionRepository;

    public DatasetDistribution createDistribution(DatasetDistribution distribution) {
        return distributionRepository.save(distribution);
    }

    public List<DatasetDistribution> getDistributionsByDatasetId(String datasetId) {
        return distributionRepository.findByDatasetId(datasetId);
    }

    public DatasetDistribution getDistributionById(String id) {
        return distributionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distribution not found with id: " + id));
    }

    public DatasetDistribution updateDistribution(DatasetDistribution distribution) {
        // Verify distribution exists
        getDistributionById(distribution.getId());
        return distributionRepository.save(distribution);
    }

    public void deleteDistribution(String id) {
        distributionRepository.deleteById(id);
    }

    public List<DatasetDistribution> getAllDistributions() {
        return distributionRepository.findAll();
    }
} 