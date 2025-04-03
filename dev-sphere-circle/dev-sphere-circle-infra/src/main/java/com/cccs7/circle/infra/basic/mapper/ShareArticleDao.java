package com.cccs7.circle.infra.basic.mapper;

import com.cccs7.circle.infra.basic.entity.ShareArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章信息(ShareArticle)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 19:39:19
 */
public interface ShareArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareArticle queryById(Long id);


    /**
     * 统计总行数
     *
     * @param shareArticle 查询条件
     * @return 总行数
     */
    long count(ShareArticle shareArticle);

    /**
     * 新增数据
     *
     * @param shareArticle 实例对象
     * @return 影响行数
     */
    int insert(ShareArticle shareArticle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareArticle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShareArticle> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareArticle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShareArticle> entities);

    /**
     * 修改数据
     *
     * @param shareArticle 实例对象
     * @return 影响行数
     */
    int update(ShareArticle shareArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    /**
     * 按条件查询
     *
     * @param shareArticle 分享文章
     * @return {@link List }<{@link ShareArticle }>
     */
    List<ShareArticle> queryByCondition(ShareArticle shareArticle);
}

