package com.cccs7.subject.domain.service.impl;

import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.domain.convert.SubjectLabelConverter;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.domain.service.SubjectLabelDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Override
    public void add(SubjectLabelBO subjectLabelBO) {

        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.bo2po(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectLabelService.insert(subjectLabel);
    }


    @Override
    public int update(SubjectLabelBO subjectLabelBO) {

        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.bo2po(subjectLabelBO);
        return subjectLabelService.update(subjectLabel);
    }

    @Override
    public int delete(SubjectLabelBO subjectLabelBO) {

        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.bo2po(subjectLabelBO);

        return subjectLabelService.delete(subjectLabel);
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {

        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.bo2po(subjectLabelBO);

        List<SubjectLabel> labelList = subjectLabelService.queryLabelByCategoryId(subjectLabel);

        return SubjectLabelConverter.INSTANCE.pos2bos(labelList);
    }
}
