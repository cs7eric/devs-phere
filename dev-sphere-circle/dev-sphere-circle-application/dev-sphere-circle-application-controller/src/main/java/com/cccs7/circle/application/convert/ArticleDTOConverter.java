package com.cccs7.circle.application.convert;

import com.cccs7.circle.application.dto.ShareArticleDTO;
import com.cccs7.circle.bo.ShareArticleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleDTOConverter {

    ArticleDTOConverter INSTANCE = Mappers.getMapper(ArticleDTOConverter.class);

    ShareArticleBO dto2bo(ShareArticleDTO shareArticleDTO);

    ShareArticleDTO bo2dto(ShareArticleBO shareArticleBO);

    List<ShareArticleDTO> bos2dtos(List<ShareArticleBO> shareArticleBOS);

    List<ShareArticleBO> dtos2bos(List<ShareArticleDTO> shareArticleDTOS);
}