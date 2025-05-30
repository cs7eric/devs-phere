package com.cccs7.circle.infra.basic.mapper;

import com.cccs7.circle.infra.basic.entity.ShareArticleLabelMapping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章标签关系表(ShareArticleLabelMapping)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 22:48:20
 */
public interface ShareArticleLabelMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareArticleLabelMapping queryById(Long id);


    /**
     * 统计总行数
     *
     * @param shareArticleLabelMapping 查询条件
     * @return 总行数
     */
    long count(ShareArticleLabelMapping shareArticleLabelMapping);

    /**
     * 新增数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 影响行数
     */
    int insert(ShareArticleLabelMapping shareArticleLabelMapping);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareArticleLabelMapping> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShareArticleLabelMapping> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareArticleLabelMapping> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShareArticleLabelMapping> entities);

    /**
     * 修改数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 影响行数
     */
    int update(ShareArticleLabelMapping shareArticleLabelMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

