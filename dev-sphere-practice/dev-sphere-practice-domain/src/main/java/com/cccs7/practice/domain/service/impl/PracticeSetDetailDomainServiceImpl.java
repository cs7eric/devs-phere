package com.cccs7.practice.domain.service.impl;

import com.cccs7.practice.common.enums.IsDeletedFlagEnum;
import com.cccs7.practice.domain.convert.PracticeSetDetailBOConverter;
import com.cccs7.practice.domain.entity.PracticeSetDetailBO;
import com.cccs7.practice.domain.service.PracticeSetDetailDomainService;
import com.cccs7.practice.infra.basic.entity.PracticeSetDetail;
import com.cccs7.practice.infra.basic.service.PracticeSetDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 套题内容表 领域service实现了
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
@Service
@Slf4j
public class PracticeSetDetailDomainServiceImpl implements PracticeSetDetailDomainService {

    @Resource
    private PracticeSetDetailService practiceSetDetailService;

    @Override
    public Boolean add(PracticeSetDetailBO practiceSetDetailBO) {
        PracticeSetDetail practiceSetDetail = PracticeSetDetailBOConverter.INSTANCE.convertBOToEntity(practiceSetDetailBO);
        practiceSetDetail.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practiceSetDetailService.insert(practiceSetDetail);
        return true;

    }

    @Override
    public Boolean update(PracticeSetDetailBO practiceSetDetailBO) {
        PracticeSetDetail practiceSetDetail = PracticeSetDetailBOConverter.INSTANCE.convertBOToEntity(practiceSetDetailBO);
        practiceSetDetailService.update(practiceSetDetail);
        return true;

    }

    @Override
    public Boolean delete(PracticeSetDetailBO practiceSetDetailBO) {
        PracticeSetDetail practiceSetDetail = new PracticeSetDetail();
        practiceSetDetail.setId(practiceSetDetailBO.getId());
        practiceSetDetail.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        practiceSetDetailService.update(practiceSetDetail);
        return true;

    }

}
