package com.example.dpwo_backend.service;

import com.example.dpwo_backend.model.Dataset;
import com.example.dpwo_backend.repository.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DatasetService {
    private final DatasetRepository datasetRepository;

    public Dataset createDataset(Dataset dataset) {
        return datasetRepository.save(dataset);
    }

    public List<Dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }
    
    public Dataset getDatasetById(String id) {
        return datasetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dataset not found with id: " + id));
    }

    public Dataset setDatasetSchema(String id, String schemaId) {
        Dataset dataset = getDatasetById(id);
        dataset.setSchemaId(schemaId);
        return datasetRepository.save(dataset);
    }

    public Dataset updateDataset(Dataset dataset) {
        // Verify dataset exists
        getDatasetById(dataset.getId());
        return datasetRepository.save(dataset);
    }
}
