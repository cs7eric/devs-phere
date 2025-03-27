package com.cccs7.practice.infra.basic.dao;

import com.cccs7.practice.infra.basic.entity.PracticeSetDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 套题内容表(PracticeSetDetail)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
public interface PracticeSetDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PracticeSetDetail queryById(Long id);


    /**
     * 统计总行数
     *
     * @param practiceSetDetail 查询条件
     * @return 总行数
     */
    long count(PracticeSetDetail practiceSetDetail);

    /**
     * 新增数据
     *
     * @param practiceSetDetail 实例对象
     * @return 影响行数
     */
    int insert(PracticeSetDetail practiceSetDetail);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PracticeSetDetail> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PracticeSetDetail> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PracticeSetDetail> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PracticeSetDetail> entities);

    /**
     * 修改数据
     *
     * @param practiceSetDetail 实例对象
     * @return 影响行数
     */
    int update(PracticeSetDetail practiceSetDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

