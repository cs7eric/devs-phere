package com.cccs7.practice.application.convert;

import com.cccs7.practice.application.dto.PracticeDetailDTO;
import com.cccs7.practice.domain.entity.PracticeDetailBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 练习详情表 dto转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:43:15
 */
@Mapper
public interface PracticeDetailDTOConverter {

    PracticeDetailDTOConverter INSTANCE = Mappers.getMapper(PracticeDetailDTOConverter.class);

    PracticeDetailBO convertDTOToBO(PracticeDetailDTO practiceDetailDTO);

}
