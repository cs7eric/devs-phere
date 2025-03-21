package com.cccs7.subject.infra.basic.mapper;

import com.cccs7.subject.infra.basic.entity.SubjectScene;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 场景、面试题信息表(SubjectScene)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-12 16:24:20
 */
public interface SubjectSceneDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectScene queryById(Long id);


    /**
     * 统计总行数
     *
     * @param subjectScene 查询条件
     * @return 总行数
     */
    long count(SubjectScene subjectScene);

    /**
     * 新增数据
     *
     * @param subjectScene 实例对象
     * @return 影响行数
     */
    int insert(SubjectScene subjectScene);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectScene> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SubjectScene> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectScene> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SubjectScene> entities);

    /**
     * 修改数据
     *
     * @param subjectScene 实例对象
     * @return 影响行数
     */
    int update(SubjectScene subjectScene);

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
     * @param subjectId 题目ID
     * @return {@link List }<{@link SubjectScene }>
     */
    List<SubjectScene> queryByCondition(SubjectScene subjectScene);
}

