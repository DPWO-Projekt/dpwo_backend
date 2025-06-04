package com.example.dpwo_backend.dataset.model;

import com.example.dpwo_backend.dataset.model.datasetdistribution.DatasetDistribution;
import com.example.dpwo_backend.dataset.model.languagespecificdatasetinfo.LanguageSpecificDatasetInfo;
import com.example.dpwo_backend.dataset.model.vcard.VCard;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "datasets")
public class Dataset {
    @Id
    private String id;
    private String uri;
    private String theme;
    private List<LanguageSpecificDatasetInfo> languageSpecificDatasetInfo;
    private String schemaId;
    private VCard vCard;
    private String parentCatalog;
    private String ownerId;
    private List<DatasetDistribution> datasetDistributions;
}
