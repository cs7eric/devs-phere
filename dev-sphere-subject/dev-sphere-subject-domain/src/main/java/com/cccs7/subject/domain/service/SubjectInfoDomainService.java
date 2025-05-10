package com.cccs7.subject.domain.service;

import com.cccs7.subject.common.entity.PageResult;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.infra.basic.entity.SubjectInfoEs;

import java.util.List;

/**
 * 题目领域服务
 * subjectInfo.bo.service
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/10
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     *
     * @param subjectInfoBO 题目信息
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目列表
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link PageResult }<{@link SubjectInfoBO }>
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目信息
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link SubjectInfoBO }
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);

    /**
     * 查询场景题目页面
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link PageResult }<{@link SubjectInfoBO }>
     */
    PageResult<SubjectInfoBO> getSceneSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 通过分类查询题目列表
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link List }<{@link SubjectInfoBO }>
     */
    List<SubjectInfoBO> getSubjectListByCategory(SubjectInfoBO subjectInfoBO);

    /**
     * 全文检索
     *
     * @param subjectInfoBO 题目信息
     * @return {@link PageResult }<{@link SubjectInfoEs }>
     */
    PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO);
}
