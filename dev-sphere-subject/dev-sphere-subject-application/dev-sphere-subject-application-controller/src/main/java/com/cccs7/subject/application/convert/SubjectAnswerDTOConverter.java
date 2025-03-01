package com.cccs7.subject.application.convert;

import com.cccs7.subject.application.dto.SubjectAnswerDTO;
import com.cccs7.subject.domain.entity.SubjectAnswerBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * SubjectAnswerDTOConverter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/10
 */
@Mapper
public interface SubjectAnswerDTOConverter {

    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);

    SubjectAnswerDTO bo2dto(SubjectAnswerBO subjectAnswerBO);

    SubjectAnswerBO dto2bo(SubjectAnswerDTO subjectAnswerDTO);

    List<SubjectAnswerDTO> bos2dtos(List<SubjectAnswerBO> boList);

    List<SubjectAnswerBO> dtos2bos(List<SubjectAnswerDTO> dtoList);

}
