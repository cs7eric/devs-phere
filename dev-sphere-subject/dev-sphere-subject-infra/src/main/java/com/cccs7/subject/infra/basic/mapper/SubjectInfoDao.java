package com.cccs7.subject.infra.basic.mapper;

import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-01 23:11:17
 */
public interface SubjectInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);

    /**
     * 统计总行数
     *
     * @param subjectInfo 查询条件
     * @return 总行数
     */
    long count(SubjectInfo subjectInfo);

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 影响行数
     */
    int insert(SubjectInfo subjectInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SubjectInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SubjectInfo> entities);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 影响行数
     */
    int update(SubjectInfo subjectInfo);

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
     * @param subjectInfo 题目信息
     * @param labelId     标签id
     * @param categoryId  分类id
     * @return int
     */
    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                            @Param("labelId") Long labelId,
                            @Param("categoryId") Long categoryId);

    /**
     * 查询分页
     *
     * @param subjectInfo 题目信息
     * @param labelId     标签id
     * @param categoryId  分类id
     * @param start       开始
     * @param pageSize    分页大小
     * @return {@link List }<{@link SubjectInfo }>
     */
    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("labelId") Long labelId,
                                @Param("categoryId") Long categoryId,
                                @Param("start") int start,
                                @Param("pageSize") Integer pageSize);
}

