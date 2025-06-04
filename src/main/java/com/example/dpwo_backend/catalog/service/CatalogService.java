package com.example.dpwo_backend.catalog.service;

import com.example.dpwo_backend.catalog.dto.CatalogResponse;
import com.example.dpwo_backend.catalog.model.Catalog;
import com.example.dpwo_backend.catalog.model.CatalogMapper;
import com.example.dpwo_backend.catalog.repository.CatalogRepository;
import com.example.dpwo_backend.dataset.model.Dataset;
import com.example.dpwo_backend.dataset.model.DatasetMapper;
import com.example.dpwo_backend.dataset.repository.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;
    private final DatasetRepository datasetRepository;
    private final DatasetMapper datasetMapper;
    private final CatalogMapper catalogMapper;

    public Catalog createCatalog(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

//    public CatalogResponse getRootCatalog() {
//        List<Catalog> catalogsWithRootAsParent =  catalogRepository.findByParentCatalogIsNull();
//        List<Dataset> datasets = datasetRepository.findByParentCatalog(null);
//
//        List<CatalogResponse> subCatalogResponses
//        CatalogResponse rootCatalog = new CatalogResponse();
//        rootCatalog.setTitle("Root Catalog");
//        rootCatalog.setDescription("This is the root catalog.");
//        rootCatalog.setParentCatalog(null);
//        rootCatalog.setDatasets(datasetMapper.toResponseList(datasets));
//        return rootCatalog;
//
//    }

    public CatalogResponse getRootCatalog() {
        List<Catalog> catalogsWithRootAsParent = catalogRepository.findByParentCatalogIsNull();
        List<Dataset> datasets = datasetRepository.findByParentCatalog(null);

        List<CatalogResponse> subCatalogResponses = catalogsWithRootAsParent.stream()
                .map(this::buildCatalogResponseRecursively)
                .toList();

        CatalogResponse rootCatalog = new CatalogResponse();
        rootCatalog.setTitle("Root Catalog");
        rootCatalog.setDescription("This is the root catalog.");
        rootCatalog.setParentCatalog(null);
        rootCatalog.setSubCatalogs(subCatalogResponses);
        rootCatalog.setDatasets(datasetMapper.toResponseList(datasets));
        return rootCatalog;
    }

    private CatalogResponse buildCatalogResponseRecursively(Catalog catalog) {
        CatalogResponse response = new CatalogResponse();
        response.setId(catalog.getId());
        response.setTitle(catalog.getTitle());
        response.setDescription(catalog.getDescription());
        response.setParentCatalog(catalog.getParentCatalog());

        // Fetch datasets for this catalog
        List<Dataset> catalogDatasets = datasetRepository.findByParentCatalog(catalog.getId());
        response.setDatasets(datasetMapper.toResponseList(catalogDatasets));

        // Recursively fetch and build subcatalogs
        List<Catalog> subCatalogs = catalogRepository.findByParentCatalog(catalog.getId());
        List<CatalogResponse> subCatalogResponses = subCatalogs.stream()
                .map(this::buildCatalogResponseRecursively)
                .toList();
        response.setSubCatalogs(subCatalogResponses);

        return response;
    }

}
