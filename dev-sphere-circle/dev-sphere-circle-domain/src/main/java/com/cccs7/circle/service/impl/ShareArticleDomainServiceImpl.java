package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareArticleBO;
import com.cccs7.circle.service.ShareArticleDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareArticleDomainServiceImpl implements ShareArticleDomainService {

    @Override
    public boolean add(ShareArticleBO shareArticleBO) {
        return false;
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
