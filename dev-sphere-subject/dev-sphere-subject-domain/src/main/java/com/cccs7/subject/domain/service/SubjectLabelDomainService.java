package com.cccs7.subject.domain.service;

import com.cccs7.subject.domain.entity.SubjectLabelBO;

import java.util.List;

public interface SubjectLabelDomainService {

    /**
     * 添加标签
     *
     * @param subjectLabelBO 主题标签bo
     */
    void add(SubjectLabelBO subjectLabelBO);

    /**
     * 更新标签
     *
     * @param subjectLabelBO 主题标签bo
     * @return int
     */
    int update(SubjectLabelBO subjectLabelBO);

    /**
     * 根据ID删除标签
     *
     * @param subjectLabelBO 主题标签bo
     * @return int
     */
    int delete(SubjectLabelBO subjectLabelBO);

    /**
     * 按分类ID查询标签
     *
     * @param subjectLabelBO 主题标签bo
     * @return {@link List }<{@link SubjectLabelBO }>
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
