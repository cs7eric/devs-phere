package com.cccs7.circle.infra.basic.service;

import com.cccs7.circle.infra.basic.entity.ShareArticle;

import java.util.List;

/**
 * 文章信息(ShareArticle)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 19:39:19
 */
public interface ShareArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareArticle queryById(Long id);


    /**
     * 新增数据
     *
     * @param shareArticle 实例对象
     * @return 实例对象
     */
    int insert(ShareArticle shareArticle);

    /**
     * 修改数据
     *
     * @param shareArticle 实例对象
     * @return 实例对象
     */
    ShareArticle update(ShareArticle shareArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 按条件查询
     *
     * @param shareArticle 分享文章
     * @return {@link List }<{@link ShareArticle }>
     */
    List<ShareArticle> queryByCondition(ShareArticle shareArticle);
}
