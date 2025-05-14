package com.cccs7.practice.application.convert;

import com.cccs7.practice.application.dto.PracticeInfoDTO;
import com.cccs7.practice.domain.entity.PracticeInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 练习表 dto转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
@Mapper
public interface PracticeInfoDTOConverter {

    PracticeInfoDTOConverter INSTANCE = Mappers.getMapper(PracticeInfoDTOConverter.class);

    PracticeInfoBO convertDTOToBO(PracticeInfoDTO practiceInfoDTO);

}
