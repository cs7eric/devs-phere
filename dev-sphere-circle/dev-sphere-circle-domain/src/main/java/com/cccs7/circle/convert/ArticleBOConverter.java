package com.cccs7.circle.convert;

import com.cccs7.circle.bo.ShareArticleBO;
import com.cccs7.circle.infra.basic.entity.ShareArticle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleBOConverter {

    ArticleBOConverter INSTANCE = Mappers.getMapper(ArticleBOConverter.class);

    ShareArticleBO po2bo(ShareArticle shareArticle);

    ShareArticle bo2po(ShareArticleBO shareArticleBO);

    List<ShareArticleBO> pos2bos(List<ShareArticle> shareArticles);

    List<ShareArticle> bos2pos(List<ShareArticleBO> shareArticleBOS);
}