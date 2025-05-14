package com.cccs7.practice.application.convert;

import com.cccs7.practice.application.dto.PracticeSetDTO;
import com.cccs7.practice.domain.entity.PracticeSetBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 套题信息表 dto转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
@Mapper
public interface PracticeSetDTOConverter {

    PracticeSetDTOConverter INSTANCE = Mappers.getMapper(PracticeSetDTOConverter.class);

    PracticeSetBO convertDTOToBO(PracticeSetDTO practiceSetDTO);

}
