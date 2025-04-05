package com.cccs7.circle.infra.basic.service;

import com.cccs7.circle.infra.basic.entity.ShareArticle;
import com.cccs7.circle.infra.basic.entity.ShareArticleLabelMapping;

import java.util.List;

/**
 * 文章标签关系表(ShareArticleLabelMapping)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 22:48:20
 */
public interface ShareArticleLabelMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareArticleLabelMapping queryById(Long id);


    /**
     * 新增数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 实例对象
     */
    ShareArticleLabelMapping insert(ShareArticleLabelMapping shareArticleLabelMapping);

    /**
     * 修改数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 实例对象
     */
    ShareArticleLabelMapping update(ShareArticleLabelMapping shareArticleLabelMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入
     *
     * @param article   文章
     * @param labelList 标签列表
     */
    void batchInsert(ShareArticle article, List<String> labelList);
}
