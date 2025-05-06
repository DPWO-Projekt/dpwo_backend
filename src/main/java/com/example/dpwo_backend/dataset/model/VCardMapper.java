package com.example.dpwo_backend.dataset.model;

import com.example.dpwo_backend.dataset.dto.VCardRequest;
import com.example.dpwo_backend.dataset.dto.VCardResponse;
import org.springframework.stereotype.Component;

@Component
public class VCardMapper {
    public VCard toEntity(VCardRequest vCardDto) {
        VCard vCard = new VCard();
        vCard.setAuthorNames(vCardDto.getAuthorNames());
        vCard.setRelatedWebsites(vCardDto.getRelatedWebsites());
        vCard.setOrgs(vCardDto.getOrgs());
        vCard.setContactEmails(vCardDto.getContactEmails());
        return vCard;
    }
    
    public VCardResponse toResponse(VCard vCard) {
        VCardResponse response = new VCardResponse();
        response.setAuthorNames(vCard.getAuthorNames());
        response.setRelatedWebsites(vCard.getRelatedWebsites());
        response.setOrgs(vCard.getOrgs());
        response.setContactEmails(vCard.getContactEmails());
        return response;
    }
}
