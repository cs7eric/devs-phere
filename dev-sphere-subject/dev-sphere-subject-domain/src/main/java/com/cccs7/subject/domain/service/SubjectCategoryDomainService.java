package com.cccs7.subject.domain.service;

import com.cccs7.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {


    /**
     * 添加分类
     *
     * @param subjectCategoryBO 主题类别bo
     */
    void add(SubjectCategoryBO subjectCategoryBO);


    /**
     * 更新分类
     *
     * @param subjectCategoryBO 主题类别bo
     * @return {@link Boolean }
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     *
     * @param subjectCategoryBO 主题类别bo
     * @return {@link List }<{@link SubjectCategoryBO }>
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     *
     * @param subjectCategoryBO 主题类别bo
     * @return {@link Boolean }
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);


    /**
     * 查询分类和标签
     *
     * @param subjectCategoryBO 题目分类薄
     * @return {@link List }<{@link SubjectCategoryBO }>
     */
    List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO);
}
