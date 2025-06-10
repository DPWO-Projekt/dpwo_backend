package com.example.dpwo_backend.dataset.controller;

import com.example.dpwo_backend.dataset.dto.DatasetRequest;
import com.example.dpwo_backend.dataset.dto.DatasetResponse;
import com.example.dpwo_backend.dataset.dto.DatasetListResponse;
import com.example.dpwo_backend.dataset.dto.dataschema.SetSchemaRequest;
import com.example.dpwo_backend.dataset.dto.datasetdistribution.DatasetDistributionRequest;
import com.example.dpwo_backend.dataset.dto.datasetdistribution.DatasetDistributionResponse;
import com.example.dpwo_backend.dataset.model.DatasetMapper;
import com.example.dpwo_backend.dataset.model.Dataset;
import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistribution;
import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistributionMapper;
import com.example.dpwo_backend.dataset.service.DatasetService;
import com.example.dpwo_backend.dataset.service.DatasetDistributionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datasetdefinition")
@RequiredArgsConstructor
public class DatasetController {
    private final DatasetService datasetService;
    private final DatasetDistributionService distributionService;
    private final DatasetMapper datasetMapper;
    private final DatasetDistributionMapper datasetDistributionMapper;

    @PostMapping
    public ResponseEntity<String> createDataset(@Valid @RequestBody DatasetRequest datasetRequest,
                                              @AuthenticationPrincipal UserDetails userDetails) {
        Dataset dataset = datasetMapper.toEntity(datasetRequest);
        dataset.setOwnerId(userDetails.getUsername());
        String id = datasetService.createDataset(dataset).getId();
        return ResponseEntity.ok("Dataset(id: " + id + ") created successfully");
    }

    @GetMapping
    public ResponseEntity<List<DatasetResponse>> getAllDatasets(Authentication authentication) {
        List<Dataset> datasets = datasetService.getAllDatasets();
        return ResponseEntity.ok(datasetMapper.toResponseList(datasets));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatasetResponse> getDataset(@PathVariable String id, Authentication authentication) {
        Dataset dataset = datasetService.getDatasetById(id);
        return ResponseEntity.ok(datasetMapper.toResponse(dataset));
    }

    @PutMapping("/setSchema")
    public ResponseEntity<DatasetResponse> setSchema(@Valid @RequestBody SetSchemaRequest request, Authentication authentication) {
        Dataset dataset = datasetService.setDatasetSchema(request.getId(), request.getSchemaId());
        return ResponseEntity.ok(datasetMapper.toResponse(dataset));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatasetResponse> updateDataset(@PathVariable String id, @Valid @RequestBody DatasetRequest datasetRequest, Authentication authentication) {
        Dataset dataset = datasetMapper.toEntity(datasetRequest);
        dataset.setId(id);
        Dataset updatedDataset = datasetService.updateDataset(dataset);
        return ResponseEntity.ok(datasetMapper.toResponse(updatedDataset));
    }

    @GetMapping("/owned")
    public ResponseEntity<DatasetListResponse> getOwnedDatasets(@AuthenticationPrincipal UserDetails userDetails) {
        DatasetListResponse response = datasetService.getOwnedDatasets(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

    // Distribution endpoints
    @GetMapping("/{datasetId}/distributions")
    public ResponseEntity<List<DatasetDistributionResponse>> getDatasetDistributions(@PathVariable String datasetId, Authentication authentication) {
        List<DatasetDistribution> distributions = distributionService.getDistributionsByDatasetId(datasetId);
        return ResponseEntity.ok(datasetDistributionMapper.toResponseList(distributions));
    }

    @PostMapping("/{datasetId}/distributions")
    public ResponseEntity<DatasetDistributionResponse> createDistribution(@PathVariable String datasetId, @Valid @RequestBody DatasetDistributionRequest distributionRequest, Authentication authentication) {
        DatasetDistribution distribution = datasetDistributionMapper.toEntity(distributionRequest, datasetId);
        DatasetDistribution createdDistribution = distributionService.createDistribution(distribution);
        return ResponseEntity.ok(datasetDistributionMapper.toResponse(createdDistribution));
    }

    @GetMapping("/distributions/{distributionId}")
    public ResponseEntity<DatasetDistributionResponse> getDistribution(@PathVariable String distributionId, Authentication authentication) {
        DatasetDistribution distribution = distributionService.getDistributionById(distributionId);
        return ResponseEntity.ok(datasetDistributionMapper.toResponse(distribution));
    }

    @PutMapping("/distributions/{distributionId}")
    public ResponseEntity<DatasetDistributionResponse> updateDistribution(@PathVariable String distributionId, @Valid @RequestBody DatasetDistributionRequest distributionRequest, Authentication authentication) {
        DatasetDistribution distribution = datasetDistributionMapper.toEntity(distributionRequest);
        distribution.setId(distributionId);
        // Preserve the existing datasetId
        DatasetDistribution existingDistribution = distributionService.getDistributionById(distributionId);
        distribution.setDatasetId(existingDistribution.getDatasetId());
        DatasetDistribution updatedDistribution = distributionService.updateDistribution(distribution);
        return ResponseEntity.ok(datasetDistributionMapper.toResponse(updatedDistribution));
    }

    @DeleteMapping("/distributions/{distributionId}")
    public ResponseEntity<String> deleteDistribution(@PathVariable String distributionId, Authentication authentication) {
        distributionService.deleteDistribution(distributionId);
        return ResponseEntity.ok("Distribution deleted successfully");
    }
}
