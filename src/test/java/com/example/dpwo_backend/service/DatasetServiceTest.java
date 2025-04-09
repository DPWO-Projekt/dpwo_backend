package com.example.dpwo_backend.service;

import com.example.dpwo_backend.model.Dataset;
import com.example.dpwo_backend.model.LanguageSpecificDatasetInfo;
import com.example.dpwo_backend.repository.DatasetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@DisplayName("Dataset Service Tests")
public class DatasetServiceTest {
    @Mock
    private DatasetRepository datasetRepository;

    @InjectMocks
    private DatasetService datasetService;

    private Dataset dataset;
    private String datasetId;
    private LanguageSpecificDatasetInfo languageSpecificDatasetInfo;

    @BeforeEach
    void setUp() {
        datasetId = "1";
        dataset = new Dataset();
        dataset.setId(datasetId);
        dataset.setTheme("Test Theme");
        languageSpecificDatasetInfo = new LanguageSpecificDatasetInfo();
        languageSpecificDatasetInfo.setTitle("Test Title");
        languageSpecificDatasetInfo.setDescription("Test Description");
        languageSpecificDatasetInfo.setKeyword(List.of("Test Keyword"));
        languageSpecificDatasetInfo.setLangCode("en");
        dataset.setLanguageSpecificDatasetInfo(List.of(languageSpecificDatasetInfo));
    }

    @Test
    @DisplayName("Should create a new dataset successfully")
    void createDataset_ShouldReturnCreatedDataset() {
        when(datasetRepository.save(any(Dataset.class))).thenReturn(dataset);

        Dataset createdDataset = datasetService.createDataset(dataset);

        assertNotNull(createdDataset);
        assertEquals(dataset.getTheme(), createdDataset.getTheme());
        verify(datasetRepository).save(any(Dataset.class));
    }

    @Test
    @DisplayName("Should get all datasets successfully")
    void getAllDatasets_ShouldReturnAllDatasets() {
        List<Dataset> datasets = List.of(dataset);
        when(datasetRepository.findAll()).thenReturn(datasets);

        List<Dataset> result = datasetService.getAllDatasets();

        assertNotNull(result);
        assertEquals(datasets, result);
        verify(datasetRepository).findAll();
    }
}
