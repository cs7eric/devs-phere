package com.cccs7.practice.infra.basic.mapper;

import com.cccs7.practice.infra.basic.entity.PracticeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 练习表(PracticeInfo)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:02
 */
public interface PracticeInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PracticeInfo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param practiceInfo 查询条件
     * @return 总行数
     */
    long count(PracticeInfo practiceInfo);

    /**
     * 新增数据
     *
     * @param practiceInfo 实例对象
     * @return 影响行数
     */
    int insert(PracticeInfo practiceInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PracticeInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PracticeInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PracticeInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PracticeInfo> entities);

    /**
     * 修改数据
     *
     * @param practiceInfo 实例对象
     * @return 影响行数
     */
    int update(PracticeInfo practiceInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

