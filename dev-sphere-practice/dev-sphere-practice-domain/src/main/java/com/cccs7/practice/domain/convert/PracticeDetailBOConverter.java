package com.cccs7.practice.domain.convert;

import com.cccs7.practice.domain.entity.PracticeDetailBO;
import com.cccs7.practice.infra.basic.entity.PracticeDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 练习详情表 bo转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:43:15
 */
@Mapper
public interface PracticeDetailBOConverter {

    PracticeDetailBOConverter INSTANCE = Mappers.getMapper(PracticeDetailBOConverter.class);

    PracticeDetail convertBOToEntity(PracticeDetailBO practiceDetailBO);

}
