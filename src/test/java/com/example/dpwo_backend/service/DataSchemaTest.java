package com.example.dpwo_backend.service;

import com.example.dpwo_backend.dataschema.model.DataSchema;
import com.example.dpwo_backend.dataschema.repository.DataSchemaRepository;
import com.example.dpwo_backend.dataschema.service.DataSchemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DataSchemaTest {
    
    @Mock
    private DataSchemaRepository dataSchemaRepository;
    
    @InjectMocks
    private DataSchemaService dataSchemaService;
    
    private DataSchema dataSchema;
    
    @BeforeEach
    void setUp() {
        Map<String, String> properties = new HashMap<>();
        properties.put("name", "string");
        properties.put("age", "number");
        
        dataSchema = new DataSchema();
        dataSchema.setId("1");
        dataSchema.setName("Person Schema");
        dataSchema.setProperties(properties);
    }
    
    @Test
    void createDataSchema_ShouldSaveToRepository() {
        // Arrange
        when(dataSchemaRepository.save(any(DataSchema.class))).thenReturn(dataSchema);
        
        // Act
        dataSchemaService.createDataSchema(dataSchema);
        
        // Assert
        verify(dataSchemaRepository).save(dataSchema);
    }
    
    @Test
    void getDataSchemas_ShouldReturnAllSchemas() {
        // Arrange
        DataSchema secondSchema = new DataSchema();
        secondSchema.setId("2");
        secondSchema.setName("Product Schema");
        Map<String, String> productProps = new HashMap<>();
        productProps.put("productName", "string");
        productProps.put("price", "number");
        secondSchema.setProperties(productProps);
        
        List<DataSchema> schemas = Arrays.asList(dataSchema, secondSchema);
        when(dataSchemaRepository.findAll()).thenReturn(schemas);
        
        // Act
        List<DataSchema> result = dataSchemaService.getDataSchemas();
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Person Schema", result.get(0).getName());
        assertEquals("Product Schema", result.get(1).getName());
    }
    
    @Test
    void getDataSchemas_ShouldReturnEmptyList_WhenNoSchemasExist() {
        // Arrange
        when(dataSchemaRepository.findAll()).thenReturn(List.of());
        
        // Act
        List<DataSchema> result = dataSchemaService.getDataSchemas();
        
        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
