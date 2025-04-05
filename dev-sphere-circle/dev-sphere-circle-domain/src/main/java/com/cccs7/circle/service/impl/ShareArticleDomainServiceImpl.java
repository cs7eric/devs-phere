package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareArticleBO;
import com.cccs7.circle.convert.ArticleBOConverter;
import com.cccs7.circle.infra.basic.entity.ShareArticle;
import com.cccs7.circle.infra.basic.entity.ShareArticleLabelMapping;
import com.cccs7.circle.infra.basic.service.ShareArticleLabelMappingService;
import com.cccs7.circle.infra.basic.service.ShareArticleService;
import com.cccs7.circle.service.ShareArticleDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShareArticleDomainServiceImpl implements ShareArticleDomainService {

    @Resource
    private ShareArticleService articleService;

    @Resource
    private ShareArticleLabelMappingService labelMappingService;

    @Override
    public boolean add(ShareArticleBO shareArticleBO) {

        ShareArticle article = ArticleBOConverter.INSTANCE.bo2po(shareArticleBO);
        article.setIsDeleted(0);
        article.setLikeCount(0);
        article.setCollectCount(0);
        article.setReplyCount(0);
        ShareArticle inserted = articleService.insert(article);

        ShareArticleLabelMapping labelMapping = new ShareArticleLabelMapping();
        labelMapping.setArticleId(inserted.getId());
        List<String> labelList = shareArticleBO.getLabelList();

        labelMappingService.batchInsert(article, labelList);

        return true;
    }

    @Override
    public Boolean update(ShareArticleBO shareArticleBO) {
        return null;
    }

    @Override
    public List<ShareArticleBO> queryArticle(ShareArticleBO shareArticleBO) {
        return null;
    }

    @Override
    public Boolean delete(ShareArticleBO shareArticleBO) {
        return null;
    }

    @Override
    public List<ShareArticleBO> query(ShareArticleBO articleBO) {
        return null;
    }
}
