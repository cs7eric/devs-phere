package com.cccs7.subject.infra.basic.service;

import com.cccs7.subject.infra.basic.entity.SubjectScene;

import java.util.LinkedList;
import java.util.List;

/**
 * 场景、面试题信息表(SubjectScene)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-12 16:24:20
 */
public interface SubjectSceneService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectScene queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectScene 实例对象
     * @return 实例对象
     */
    SubjectScene insert(SubjectScene subjectScene);

    /**
     * 修改数据
     *
     * @param subjectScene 实例对象
     * @return 实例对象
     */
    SubjectScene update(SubjectScene subjectScene);

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
     * @param suggestList 显示列表
     * @return int
     */
    int batchInsert(LinkedList<SubjectScene> suggestList);

    /**
     * 按条件查询
     *
     * @param subjectId 题目ID
     * @return {@link List }<{@link SubjectScene }>
     */
    List<SubjectScene> queryByCondition(int subjectId);
}
