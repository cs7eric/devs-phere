package com.cccs7.circle.service;

import com.cccs7.circle.bo.ShareArticleBO;

import java.util.List;

public interface ShareArticleDomainService {

    /**
     * 添加文章
     *
     * @param shareArticleBO 文章BO
     */
    boolean add(ShareArticleBO shareArticleBO);

    /**
     * 更新文章
     *
     * @param shareArticleBO 文章BO
     * @return {@link Boolean }
     */
    Boolean update(ShareArticleBO shareArticleBO);

    /**
     * 查询文章
     *
     * @param shareArticleBO 文章BO
     * @return {@link List }<{@link ShareArticleBO }>
     */
    List<ShareArticleBO> queryArticle(ShareArticleBO shareArticleBO);

    /**
     * 删除文章
     *
     * @param shareArticleBO 文章BO
     * @return {@link Boolean }
     */
    Boolean delete(ShareArticleBO shareArticleBO);

    List<ShareArticleBO> query(ShareArticleBO articleBO);

    /**
     * 查询文章通过圈子ID
     *
     * @param articleBO 篇博
     * @return {@link List }<{@link ShareArticleBO }>
     */
    List<ShareArticleBO> getArticleByCircle(ShareArticleBO articleBO);
}