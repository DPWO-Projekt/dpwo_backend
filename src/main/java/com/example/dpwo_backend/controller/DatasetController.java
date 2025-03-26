package com.example.dpwo_backend.controller;

import com.example.dpwo_backend.dto.dataset.DatasetRequest;
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
@RequestMapping("/api/dataset")
@RequiredArgsConstructor
public class DatasetController {
    private final DatasetService datasetService;
    private final DatasetMapper datasetMapper;

    @PostMapping
    public ResponseEntity<String> createDataset(@Valid @RequestBody DatasetRequest datasetRequest,
                                                Authentication authentication) {
        Dataset dataset = datasetMapper.toEntity(datasetRequest);
        datasetService.createDataset(dataset);
        return ResponseEntity.ok("Dataset created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Dataset>> getAllDatasets(Authentication authentication) {
        return ResponseEntity.ok(datasetService.getAllDatasets());
    }

}
