package com.example.dpwo_backend.dataset.dto;

import com.example.dpwo_backend.dataset.dto.languagespecificdatasetinfo.LanguageSpecificDatasetInfoResponse;
import com.example.dpwo_backend.dataset.dto.vcard.VCardResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class DatasetResponse {
    private String id;
    private String uri;
    private String theme;
    private String schemaId;
    @JsonProperty("vCard")
    private VCardResponse vCard;
    private List<LanguageSpecificDatasetInfoResponse> languageSpecificDatasetInfo;
    @JsonProperty("parentCatalog")
    private String parentCatalog;
}