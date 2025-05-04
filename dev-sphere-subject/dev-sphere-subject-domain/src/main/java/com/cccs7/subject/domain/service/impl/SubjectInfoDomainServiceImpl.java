package com.cccs7.subject.domain.service.impl;


import com.alibaba.fastjson.JSON;
import com.cccs7.subject.common.entity.PageResult;
import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.convert.SubjectInfoConverter;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.entity.SubjectOptionBO;
import com.cccs7.subject.domain.handler.subject.SubjectTypeHandler;
import com.cccs7.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.cccs7.subject.domain.service.SubjectInfoDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.entity.SubjectMapping;
import com.cccs7.subject.infra.basic.service.SubjectInfoService;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import com.cccs7.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private SubjectLabelService subjectLabelService;


    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainService.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.bo2po(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
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
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                mappingList.add(subjectMapping);
            });
        });

        subjectMappingService.batchInsert(mappingList);
    }


    /**
     * 分页查询题目列表
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link PageResult }<{@link SubjectInfoBO }>
     */
    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.bo2po(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo,
                subjectInfoBO.getLabelId(),
                subjectInfoBO.getCategoryId());

        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getLabelId(),
                subjectInfoBO.getCategoryId(), start, subjectInfoBO.getPageSize());

        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.pos2bos(subjectInfoList);
        pageResult.setTotal(count);
        pageResult.setRecords(subjectInfoBOList);
        return pageResult;
    }

    /**
     * 查询题目信息
     *
     * @param subjectInfoBO 题目信息薄
     * @return {@link SubjectInfoBO }
     */
    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {

        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.optionAndInfo2bo(optionBO, subjectInfo);
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList
                = mappingList.stream()
                .map(SubjectMapping::getLabelId)
                .collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList
                = labelList.stream()
                .map(SubjectLabel::getLabelName)
                .collect(Collectors.toList());
        bo.setLabelName(labelNameList);
        return bo;
    }

    @Override
    public PageResult<SubjectInfoBO> getSceneSubjectPage(SubjectInfoBO subjectInfoBO) {

        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.bo2po(subjectInfoBO);
        int count = subjectInfoService.countBySceneType(subjectInfo, (long) SubjectInfoTypeEnum.SCENE.code);

        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryConditionByPage(subjectInfo, SubjectInfoTypeEnum.SCENE.code, start, subjectInfoBO.getPageSize());

        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.pos2bos(subjectInfoList);
        pageResult.setTotal(count);
        pageResult.setRecords(subjectInfoBOList);
        return pageResult;
    }

    @Override
    public List<SubjectInfoBO> getSubjectListByCategory(SubjectInfoBO subjectInfoBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainService.getSubjectListByCategory.bo:{}", JSON.toJSONString(subjectInfoBO));
        }

        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.bo2po(subjectInfoBO);

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setLabelId(subjectInfoBO.getLabelId());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> subjectIdList = mappingList.stream().map(SubjectMapping::getSubjectId).collect(Collectors.toList());
        List<SubjectInfo> subjectInfoList = subjectInfoService.getSubjectsByIds(subjectIdList);
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.pos2bos(subjectInfoList);
        return subjectInfoBOList;
    }
}


