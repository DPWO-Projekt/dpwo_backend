package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataset.VCardRequest;
import com.example.dpwo_backend.dto.dataset.VCardResponse;
import com.example.dpwo_backend.model.VCard;
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
