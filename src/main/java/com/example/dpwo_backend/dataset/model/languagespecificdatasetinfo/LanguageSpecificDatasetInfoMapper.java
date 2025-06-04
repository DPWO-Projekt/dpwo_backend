package com.example.dpwo_backend.dataset.model.languagespecificdatasetinfo;

import com.example.dpwo_backend.dataset.dto.languagespecificdatasetinfo.LanguageSpecificDatasetInfoRequest;
import com.example.dpwo_backend.dataset.dto.languagespecificdatasetinfo.LanguageSpecificDatasetInfoResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LanguageSpecificDatasetInfoMapper {

    public LanguageSpecificDatasetInfo toEntity(LanguageSpecificDatasetInfoRequest infoDto) {
        LanguageSpecificDatasetInfo info = new LanguageSpecificDatasetInfo();
        info.setTitle(infoDto.getTitle());
        info.setDescription(infoDto.getDescription());
        info.setKeyword(infoDto.getKeyword());
        info.setLangCode(infoDto.getLangCode());
        return info;
    }
    
    public LanguageSpecificDatasetInfoResponse toResponse(LanguageSpecificDatasetInfo info) {
        LanguageSpecificDatasetInfoResponse response = new LanguageSpecificDatasetInfoResponse();
        response.setTitle(info.getTitle());
        response.setDescription(info.getDescription());
        response.setKeyword(info.getKeyword());
        response.setLangCode(info.getLangCode());
        return response;
    }
    
    public List<LanguageSpecificDatasetInfoResponse> toResponseList(List<LanguageSpecificDatasetInfo> infoList) {
        return infoList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
