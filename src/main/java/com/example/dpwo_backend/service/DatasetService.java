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
}
