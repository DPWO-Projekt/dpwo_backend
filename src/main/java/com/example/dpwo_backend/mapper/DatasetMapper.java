package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataset.DatasetRequest;
import com.example.dpwo_backend.model.Dataset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatasetMapper {
    private final LanguageSpecificDatasetInfoMapper languageSpecificDatasetInfoMapper;

    public Dataset toEntity(DatasetRequest datasetRequest) {
        Dataset dataset = new Dataset();
        dataset.setTheme(datasetRequest.getTheme());
        dataset.setLanguageSpecificDatasetInfos(
                datasetRequest.getDatasetInfo().stream().map(languageSpecificDatasetInfoMapper::toEntity).toList());
        return dataset;
    }
}
