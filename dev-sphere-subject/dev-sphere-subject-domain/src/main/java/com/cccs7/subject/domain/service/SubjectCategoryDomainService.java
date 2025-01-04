package com.cccs7.subject.domain.service;

import com.cccs7.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBO subjectCategoryBO);


    Boolean update(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryCatefory(SubjectCategoryBO subjectCategoryBO);
}
