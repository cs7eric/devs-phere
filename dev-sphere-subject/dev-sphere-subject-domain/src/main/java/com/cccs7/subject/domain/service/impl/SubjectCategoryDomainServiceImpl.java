package com.cccs7.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.domain.convert.SubjectCategoryConverter;
import com.cccs7.subject.domain.entity.SubjectCategoryBO;
import com.cccs7.subject.domain.service.SubjectCategoryDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import com.cccs7.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {


    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo: {}", subjectCategoryBO);
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.update.bo: {}", subjectCategoryBO);
        }

        try {
            SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
            subjectCategoryService.update(subjectCategory);
            return true;
        } catch (Exception e) {
            log.error("SubjectCategoryDomainService.update.bo:{}", subjectCategoryBO);
            return false;
        }
    }


    @Override
    public List<SubjectCategoryBO> queryCatefory(SubjectCategoryBO subjectCategoryBO) {


        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConverter.INSTANCE.pos2bos(subjectCategoryList);

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(subjectCategoryBOList));
        }

        subjectCategoryBOList.forEach(bo -> {
            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });
        return subjectCategoryBOList;
    }
}
