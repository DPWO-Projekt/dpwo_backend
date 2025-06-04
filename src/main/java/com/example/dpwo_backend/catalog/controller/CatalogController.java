package com.example.dpwo_backend.catalog.controller;


import com.example.dpwo_backend.catalog.dto.CatalogRequest;
import com.example.dpwo_backend.catalog.dto.CatalogResponse;
import com.example.dpwo_backend.catalog.model.Catalog;
import com.example.dpwo_backend.catalog.model.CatalogMapper;
import com.example.dpwo_backend.catalog.service.CatalogService;
import com.example.dpwo_backend.dataschema.dto.DataSchemaRequest;
import com.example.dpwo_backend.dataschema.dto.DataSchemaResponse;
import com.example.dpwo_backend.dataschema.model.DataSchemaMapper;
import com.example.dpwo_backend.dataschema.model.DataSchema;
import com.example.dpwo_backend.dataschema.service.DataSchemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;
    private final CatalogMapper catalogMapper;

    @PostMapping
    public ResponseEntity<CatalogResponse> createDataSchema(@Valid @RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogMapper.toEntity(catalogRequest);
        Catalog resultCatalog = catalogService.createCatalog(catalog);
        return ResponseEntity.ok(catalogMapper.toResponse(resultCatalog));
    }

    @GetMapping("")
    public ResponseEntity<CatalogResponse> getRootCatalog() {
        return ResponseEntity.ok(catalogService.getRootCatalog());
    }

}
