package com.cccs7.practice.domain.service.impl;

import com.cccs7.practice.common.enums.IsDeletedFlagEnum;
import com.cccs7.practice.domain.convert.PracticeInfoBOConverter;
import com.cccs7.practice.domain.entity.PracticeInfoBO;
import com.cccs7.practice.domain.service.PracticeInfoDomainService;
import com.cccs7.practice.infra.basic.entity.PracticeInfo;
import com.cccs7.practice.infra.basic.service.PracticeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 练习表 领域service实现了
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
@Service
@Slf4j
public class PracticeInfoDomainServiceImpl implements PracticeInfoDomainService {

    @Resource
    private PracticeInfoService practiceInfoService;

    @Override
    public Boolean add(PracticeInfoBO practiceInfoBO) {
        PracticeInfo practiceInfo = PracticeInfoBOConverter.INSTANCE.convertBOToEntity(practiceInfoBO);
        practiceInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practiceInfoService.insert(practiceInfo);
        return true;

    }

    @Override
    public Boolean update(PracticeInfoBO practiceInfoBO) {
        PracticeInfo practiceInfo = PracticeInfoBOConverter.INSTANCE.convertBOToEntity(practiceInfoBO);
        practiceInfoService.update(practiceInfo);
        return true;

    }

    @Override
    public Boolean delete(PracticeInfoBO practiceInfoBO) {
        PracticeInfo practiceInfo = new PracticeInfo();
        practiceInfo.setId(practiceInfoBO.getId());
        practiceInfo.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
       practiceInfoService.update(practiceInfo);
        return true;

    }

}
