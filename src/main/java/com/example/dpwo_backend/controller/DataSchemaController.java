package com.example.dpwo_backend.controller;


import com.example.dpwo_backend.dto.dataschema.DataSchemaRequest;
import com.example.dpwo_backend.dto.dataschema.DataSchemaResponse;
import com.example.dpwo_backend.mapper.DataSchemaMapper;
import com.example.dpwo_backend.model.DataSchema;
import com.example.dpwo_backend.service.DataSchemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dataschema")
@RequiredArgsConstructor
public class DataSchemaController {

    private final DataSchemaService dataSchemaService;
    private final DataSchemaMapper dataSchemaMapper;

    @PostMapping
    public ResponseEntity<String> createDataSchema(@Valid @RequestBody DataSchemaRequest dataSchemaRequest) {
        DataSchema dataSchema = dataSchemaMapper.toEntity(dataSchemaRequest);
        dataSchemaService.createDataSchema(dataSchema);
        return ResponseEntity.ok("Data schema created successfully");
    }

    @GetMapping
    public ResponseEntity<List<DataSchemaResponse>> getDataSchemas() {
        List<DataSchema> dataSchemas = dataSchemaService.getDataSchemas();
        return ResponseEntity.ok(dataSchemaMapper.toResponseList(dataSchemas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataSchemaResponse> getDataSchema(@PathVariable String id) {
        DataSchema dataSchema = dataSchemaService.getDataSchema(id);
        return ResponseEntity.ok(dataSchemaMapper.toResponse(dataSchema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDataSchema(@PathVariable String id, @Valid @RequestBody DataSchemaRequest dataSchemaRequest) {
        DataSchema dataSchema = dataSchemaMapper.toEntity(dataSchemaRequest);
        dataSchema.setId(id);
        dataSchemaService.createDataSchema(dataSchema);
        return ResponseEntity.ok("Data schema updated successfully");
    }

}
