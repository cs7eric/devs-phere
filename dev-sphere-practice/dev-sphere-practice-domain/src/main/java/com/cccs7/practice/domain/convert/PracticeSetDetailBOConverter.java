package com.cccs7.practice.domain.convert;

import com.cccs7.practice.domain.entity.PracticeSetDetailBO;
import com.cccs7.practice.infra.basic.entity.PracticeSetDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 套题内容表 bo转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
@Mapper
public interface PracticeSetDetailBOConverter {

    PracticeSetDetailBOConverter INSTANCE = Mappers.getMapper(PracticeSetDetailBOConverter.class);

    PracticeSetDetail convertBOToEntity(PracticeSetDetailBO practiceSetDetailBO);

}
