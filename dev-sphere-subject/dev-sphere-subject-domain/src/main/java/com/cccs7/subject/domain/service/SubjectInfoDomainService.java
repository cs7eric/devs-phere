package com.cccs7.subject.domain.service;

import com.cccs7.subject.domain.entity.SubjectInfoBO;

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
}
