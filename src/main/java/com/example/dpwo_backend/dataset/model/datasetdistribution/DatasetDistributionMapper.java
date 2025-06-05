package com.example.dpwo_backend.dataset.model.datasetdistribution;

import com.example.dpwo_backend.dataset.dto.datasetdistribution.DatasetDistributionRequest;
import com.example.dpwo_backend.dataset.dto.datasetdistribution.DatasetDistributionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatasetDistributionMapper {
    public DatasetDistribution toEntity(DatasetDistributionRequest datasetDistributionRequest) {
        DatasetDistribution datasetDistribution = new DatasetDistribution();
        datasetDistribution.setUrl(datasetDistributionRequest.getUrl());
        datasetDistribution.setAvailability(datasetDistributionRequest.getAvailability());
        datasetDistribution.setFormat(datasetDistributionRequest.getFormat());
        datasetDistribution.setTitle(datasetDistributionRequest.getTitle());
        datasetDistribution.setDescription(datasetDistributionRequest.getDescription());
        return datasetDistribution;
    }

    public DatasetDistributionResponse toResponse(DatasetDistribution datasetDistribution) {
        DatasetDistributionResponse response = new DatasetDistributionResponse();
        response.setId(datasetDistribution.getId());
        response.setUrl(datasetDistribution.getUrl());
        response.setAvailability(datasetDistribution.getAvailability());
        response.setFormat(datasetDistribution.getFormat());
        response.setTitle(datasetDistribution.getTitle());
        response.setDescription(datasetDistribution.getDescription());
        return response;
    }

    public List<DatasetDistributionResponse> toResponseList(List<DatasetDistribution> datasetDistributions) {
        return datasetDistributions.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
