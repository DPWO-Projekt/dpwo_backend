package com.example.dpwo_backend.catalog.repository;

import com.example.dpwo_backend.catalog.model.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CatalogRepository extends MongoRepository<Catalog, String> {
    List<Catalog> findByParentCatalogIsNull();
    List<Catalog> findByParentCatalog(String parentCatalogId);
}