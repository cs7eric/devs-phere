package com.cccs7.practice.domain.convert;

import com.cccs7.practice.domain.entity.PracticeInfoBO;
import com.cccs7.practice.infra.basic.entity.PracticeInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 练习表 bo转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
@Mapper
public interface PracticeInfoBOConverter {

    PracticeInfoBOConverter INSTANCE = Mappers.getMapper(PracticeInfoBOConverter.class);

    PracticeInfo convertBOToEntity(PracticeInfoBO practiceInfoBO);

}
