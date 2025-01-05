package com.cccs7.subject.domain.service.impl;

import com.cccs7.subject.domain.convert.SubjectLabelConverter;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.domain.service.SubjectLabelDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    public void add(SubjectLabelBO subjectLabelBO) {

        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.bo2po(subjectLabelBO);
        subjectLabelService.insert(subjectLabel);
    }
}
