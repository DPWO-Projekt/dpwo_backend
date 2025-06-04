package com.example.dpwo_backend.dataset.service;

import com.example.dpwo_backend.dataset.dto.DatasetListResponse;
import com.example.dpwo_backend.dataset.model.Dataset;
import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistribution;
import com.example.dpwo_backend.dataset.repository.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<DatasetDistribution> getDatasetDistributions(String id) {
        return getDatasetById(id).getDatasetDistributions();
    }

    public DatasetListResponse getOwnedDatasets(String ownerId) {
        List<Dataset> datasets = datasetRepository.findByOwnerId(ownerId);

        DatasetListResponse response = new DatasetListResponse();
        response.setDatasets(datasets.stream()
            .map(this::mapToDatasetListItem)
            .collect(Collectors.toList()));

        return response;
    }

    private DatasetListResponse.DatasetListItem mapToDatasetListItem(Dataset dataset) {
        DatasetListResponse.DatasetListItem item = new DatasetListResponse.DatasetListItem();
        item.setId(dataset.getId());
        item.setUri(dataset.getUri());
        item.setTheme(dataset.getTheme());

        // Get the first language-specific info for title and description
        if (dataset.getLanguageSpecificDatasetInfo() != null && !dataset.getLanguageSpecificDatasetInfo().isEmpty()) {
            var info = dataset.getLanguageSpecificDatasetInfo().get(0);
            item.setTitle(info.getTitle());
            item.setDescription(info.getDescription());
        }

        return item;
    }
}
