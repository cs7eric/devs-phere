package com.cccs7.practice.application.convert;

import com.cccs7.practice.application.dto.PracticeSetDetailDTO;
import com.cccs7.practice.domain.entity.PracticeSetDetailBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 套题内容表 dto转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
@Mapper
public interface PracticeSetDetailDTOConverter {

    PracticeSetDetailDTOConverter INSTANCE = Mappers.getMapper(PracticeSetDetailDTOConverter.class);

    PracticeSetDetailBO convertDTOToBO(PracticeSetDetailDTO practiceSetDetailDTO);

}
