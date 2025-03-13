package com.cccs7.subject.infra.basic.service;

import com.cccs7.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2025-01-01 23:11:17
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    int countByCondition(SubjectInfo subjectInfo, Long labelId, Long categoryId);

    /**
     * 分页查询
     *
     * @param subjectInfo 题目信息
     * @param labelId     标签id
     * @param categoryId  分类id
     * @param start       开始
     * @param pageSize    页面大小
     * @return {@link List }<{@link SubjectInfo }>
     */
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long labelId, Long categoryId, int start, Integer pageSize);

    /**
     * 按场景题类型计数
     *
     * @param subjectInfo 题目信息
     * @param subjectType 题目类型
     * @return int
     */
    int countBySceneType(SubjectInfo subjectInfo, Long subjectType);


    /**
     * 按页查询条件
     *
     * @param subjectInfo 题目信息
     * @param subjectType 题目类型
     * @param start       开始
     * @param pageSize    页面大小
     * @return {@link List }<{@link SubjectInfo }>
     */
    List<SubjectInfo> queryConditionByPage(SubjectInfo subjectInfo, Integer subjectType, int start, Integer pageSize);
}
