package com.cccs7.subject.infra.basic.service;

import com.cccs7.subject.common.entity.PageResult;
import com.cccs7.subject.infra.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);
}
