package com.cccs7.practice.domain.service.impl;

import com.cccs7.practice.common.enums.IsDeletedFlagEnum;
import com.cccs7.practice.domain.convert.PracticeDetailBOConverter;
import com.cccs7.practice.domain.entity.PracticeDetailBO;
import com.cccs7.practice.domain.service.PracticeDetailDomainService;
import com.cccs7.practice.infra.basic.entity.PracticeDetail;
import com.cccs7.practice.infra.basic.service.PracticeDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 练习详情表 领域service实现了
 *
 * @author cccs7
 * @since 2025-05-14 23:43:15
 */
@Service
@Slf4j
public class PracticeDetailDomainServiceImpl implements PracticeDetailDomainService {

    @Resource
    private PracticeDetailService practiceDetailService;

    @Override
    public Boolean add(PracticeDetailBO practiceDetailBO) {
        PracticeDetail practiceDetail = PracticeDetailBOConverter.INSTANCE.convertBOToEntity(practiceDetailBO);
        practiceDetail.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practiceDetailService.insert(practiceDetail);
        return true;
    }

    @Override
    public Boolean update(PracticeDetailBO practiceDetailBO) {
        PracticeDetail practiceDetail = PracticeDetailBOConverter.INSTANCE.convertBOToEntity(practiceDetailBO);
        practiceDetailService.update(practiceDetail);
        return true;

    }

    @Override
    public Boolean delete(PracticeDetailBO practiceDetailBO) {
        PracticeDetail practiceDetail = new PracticeDetail();
        practiceDetail.setId(practiceDetailBO.getId());
        practiceDetail.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        practiceDetailService.update(practiceDetail);
        return true;

    }

}
