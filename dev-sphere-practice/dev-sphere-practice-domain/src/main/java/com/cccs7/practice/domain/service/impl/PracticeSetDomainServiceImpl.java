package com.cccs7.practice.domain.service.impl;

import com.cccs7.practice.common.enums.IsDeletedFlagEnum;
import com.cccs7.practice.domain.convert.PracticeSetBOConverter;
import com.cccs7.practice.domain.entity.PracticeSetBO;
import com.cccs7.practice.domain.service.PracticeSetDomainService;
import com.cccs7.practice.infra.basic.entity.PracticeSet;
import com.cccs7.practice.infra.basic.service.PracticeSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 套题信息表 领域service实现了
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
@Service
@Slf4j
public class PracticeSetDomainServiceImpl implements PracticeSetDomainService {

    @Resource
    private PracticeSetService practiceSetService;

    @Override
    public Boolean add(PracticeSetBO practiceSetBO) {
        PracticeSet practiceSet = PracticeSetBOConverter.INSTANCE.convertBOToEntity(practiceSetBO);
        practiceSet.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        practiceSetService.insert(practiceSet);
        return true;

    }

    @Override
    public Boolean update(PracticeSetBO practiceSetBO) {
        PracticeSet practiceSet = PracticeSetBOConverter.INSTANCE.convertBOToEntity(practiceSetBO);
        practiceSetService.update(practiceSet);
        return true;

    }

    @Override
    public Boolean delete(PracticeSetBO practiceSetBO) {
        PracticeSet practiceSet = new PracticeSet();
        practiceSet.setId(practiceSetBO.getId());
        practiceSet.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        practiceSetService.update(practiceSet);
        return true;

    }

}
