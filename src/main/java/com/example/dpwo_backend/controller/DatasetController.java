package com.example.dpwo_backend.controller;

import com.example.dpwo_backend.dto.dataset.DatasetRequest;
import com.example.dpwo_backend.dto.dataset.SetSchemaRequest;
import com.example.dpwo_backend.mapper.DatasetMapper;
import com.example.dpwo_backend.model.Dataset;
import com.example.dpwo_backend.service.DatasetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datasetdefinition")
@RequiredArgsConstructor
public class DatasetController {
    private final DatasetService datasetService;
    private final DatasetMapper datasetMapper;

    @PostMapping
    public ResponseEntity<String> createDataset(@Valid @RequestBody DatasetRequest datasetRequest,
                                                Authentication authentication) {
        Dataset dataset = datasetMapper.toEntity(datasetRequest);
        String id = datasetService.createDataset(dataset).getId();
        return ResponseEntity.ok("Dataset(id: " + id + ") created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Dataset>> getAllDatasets(Authentication authentication) {
        return ResponseEntity.ok(datasetService.getAllDatasets());
    }

    @PutMapping("/setSchema")
    public void setSchema(@Valid @RequestBody SetSchemaRequest request, Authentication authentication) {
        datasetService.setDatasetSchema(request.getId(), request.getSchemaId());
    }

    @PutMapping("/{id}")
    public void updateDataset(@PathVariable String id, @Valid @RequestBody DatasetRequest datasetRequest, Authentication authentication) {
        Dataset dataset = datasetMapper.toEntity(datasetRequest);
        dataset.setId(id);
        datasetService.updateDataset(dataset);
    }
}
