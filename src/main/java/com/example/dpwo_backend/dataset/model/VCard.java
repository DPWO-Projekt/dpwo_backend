package com.example.dpwo_backend.dataset.model;

import lombok.Data;
import java.util.List;

@Data
public class VCard {
    private List<String> authorNames;
    private List<String> relatedWebsites;
    private List<String> orgs;
    private List<String> contactEmails;
}
