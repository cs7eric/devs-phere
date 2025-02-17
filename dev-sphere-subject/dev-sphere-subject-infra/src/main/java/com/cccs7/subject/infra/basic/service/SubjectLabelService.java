package com.cccs7.subject.infra.basic.service;

import com.cccs7.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2025-01-01 23:12:00
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 逻辑删除
     *
     * @param subjectLabel 主题标签
     * @return int
     */
    int delete(SubjectLabel subjectLabel);

    /**
     * 通过分类id查询标签
     *
     * @param subjectLabel 题目标签
     * @return {@link List }<{@link SubjectLabel }>
     */
    List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel);

    /**
     * 按id批量查询
     *
     * @param labelIdList 标签id列表
     * @return {@link List }<{@link SubjectLabel }>
     */
    List<SubjectLabel> batchQueryById(List<Long> labelIdList);
}
