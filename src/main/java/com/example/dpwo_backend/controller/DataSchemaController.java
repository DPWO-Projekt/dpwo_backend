package com.example.dpwo_backend.controller;


import com.example.dpwo_backend.dto.dataschema.DataSchemaRequest;
import com.example.dpwo_backend.dto.dataschema.DataSchemaResponse;
import com.example.dpwo_backend.mapper.DataSchemaMapper;
import com.example.dpwo_backend.model.DataSchema;
import com.example.dpwo_backend.service.DataSchemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dataschema")
@RequiredArgsConstructor
public class DataSchemaController {

    private final DataSchemaService dataSchemaService;
    private final DataSchemaMapper dataSchemaMapper;

    @PostMapping
    public ResponseEntity<String> createDataSchema(@Valid @RequestBody DataSchemaRequest dataSchemaRequest, Authentication authentication) {
        DataSchema dataSchema = dataSchemaMapper.toEntity(dataSchemaRequest);
        dataSchemaService.createDataSchema(dataSchema);
        return ResponseEntity.ok("Data schema created successfully");
    }

    @GetMapping
    public ResponseEntity<List<DataSchemaResponse>> getDataSchemas() {
        List<DataSchema> dataSchemas = dataSchemaService.getDataSchemas();
        return ResponseEntity.ok(dataSchemaMapper.toResponseList(dataSchemas));
    }


}
