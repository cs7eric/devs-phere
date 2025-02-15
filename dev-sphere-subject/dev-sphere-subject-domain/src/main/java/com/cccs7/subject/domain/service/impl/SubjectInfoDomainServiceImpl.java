package com.cccs7.subject.domain.service.impl;


import com.alibaba.fastjson.JSON;
import com.cccs7.subject.domain.convert.SubjectInfoConverter;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.handler.subject.SubjectTypeHandler;
import com.cccs7.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.cccs7.subject.domain.service.SubjectInfoDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import com.cccs7.subject.infra.basic.entity.SubjectMapping;
import com.cccs7.subject.infra.basic.service.SubjectInfoService;
import com.cccs7.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * subjectInfo.bo.service
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/10
 */
@Slf4j
@Service
public class SubjectInfoDomainServiceImpl
        implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SujectInfoDomainService.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.bo2po(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();

        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                mappingList.add(subjectMapping);
            });
        });

        subjectMappingService.batchInsert(mappingList);


    }
}
