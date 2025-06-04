package com.example.dpwo_backend.catalog.model;

import com.example.dpwo_backend.catalog.dto.CatalogRequest;
import com.example.dpwo_backend.catalog.dto.CatalogResponse;
import com.example.dpwo_backend.dataschema.dto.DataSchemaRequest;
import com.example.dpwo_backend.dataschema.dto.DataSchemaResponse;
import com.example.dpwo_backend.dataschema.model.DataSchema;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogMapper {

    public Catalog toEntity(CatalogRequest catalogRequest) {
        Catalog catalog = new Catalog();
        catalog.setTitle(catalogRequest.getTitle());
        catalog.setDescription(catalogRequest.getDescription());
        catalog.setParentCatalog(catalogRequest.getParentCatalog());
        return catalog;
    }

    public CatalogResponse toResponse(Catalog catalog) {
        CatalogResponse response = new CatalogResponse();
        response.setId(catalog.getId());
        response.setTitle(catalog.getTitle());
        response.setDescription(catalog.getDescription());
        response.setParentCatalog(catalog.getParentCatalog());
        return response;
    }

    public List<CatalogResponse> toResponseList(List<Catalog> catalogs) {
        return catalogs.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
