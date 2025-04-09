package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataset.DatasetRequest;
import com.example.dpwo_backend.dto.dataset.DatasetResponse;
import com.example.dpwo_backend.model.Dataset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatasetMapper {
    private final LanguageSpecificDatasetInfoMapper languageSpecificDatasetInfoMapper;
    private final VCardMapper vCardMapper;

    public Dataset toEntity(DatasetRequest datasetRequest) {
        Dataset dataset = new Dataset();
        dataset.setUri(datasetRequest.getUri());
        dataset.setTheme(datasetRequest.getTheme());
        dataset.setLanguageSpecificDatasetInfo(
                datasetRequest.getLanguageSpecificDatasetInfo().stream().map(languageSpecificDatasetInfoMapper::toEntity).toList());
        dataset.setVCard(vCardMapper.toEntity(datasetRequest.getVCard()));
        dataset.setSchemaId(datasetRequest.getSchemaId());
        return dataset;
    }
    
    public DatasetResponse toResponse(Dataset dataset) {
        DatasetResponse response = new DatasetResponse();
        response.setId(dataset.getId());
        response.setUri(dataset.getUri());
        response.setTheme(dataset.getTheme());
        response.setLanguageSpecificDatasetInfo(
                languageSpecificDatasetInfoMapper.toResponseList(dataset.getLanguageSpecificDatasetInfo()));
        response.setSchemaId(dataset.getSchemaId());
        if (dataset.getVCard() != null) {
            response.setVCard(vCardMapper.toResponse(dataset.getVCard()));
        }
        return response;
    }
    
    public List<DatasetResponse> toResponseList(List<Dataset> datasets) {
        return datasets.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
