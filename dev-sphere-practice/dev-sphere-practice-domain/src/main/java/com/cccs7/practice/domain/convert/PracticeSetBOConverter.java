package com.cccs7.practice.domain.convert;

import com.cccs7.practice.domain.entity.PracticeSetBO;
import com.cccs7.practice.infra.basic.entity.PracticeSet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 套题信息表 bo转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
@Mapper
public interface PracticeSetBOConverter {

    PracticeSetBOConverter INSTANCE = Mappers.getMapper(PracticeSetBOConverter.class);

    PracticeSet convertBOToEntity(PracticeSetBO practiceSetBO);

}
