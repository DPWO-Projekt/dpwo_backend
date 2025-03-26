package com.example.dpwo_backend.mapper;

import com.example.dpwo_backend.dto.dataset.LanguageSpecificDatasetInfoRequest;
import com.example.dpwo_backend.model.LanguageSpecificDatasetInfo;
import org.springframework.stereotype.Component;

@Component
public class LanguageSpecificDatasetInfoMapper {

    public LanguageSpecificDatasetInfo toEntity(LanguageSpecificDatasetInfoRequest infoDto) {
        LanguageSpecificDatasetInfo info = new LanguageSpecificDatasetInfo();
        info.setTitle(infoDto.getTitle());
        info.setDescription(infoDto.getDescription());
        info.setKeywords(infoDto.getKeywords());
        info.setLanguageCode(infoDto.getLanguageCode());
        return info;
    }
}
