package com.example.dpwo_backend.dto.dataset;

import lombok.Data;

import java.util.List;

@Data
public class VCardRequest {
    private List<String> authorNames;
    private List<String> relatedWebsites;
    private List<String> orgs;
    private List<String> contactEmails;
}
