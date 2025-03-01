package com.cccs7.subject.application.convert;

import com.cccs7.subject.application.dto.SubjectCategoryDTO;
import com.cccs7.subject.application.dto.SubjectInfoDTO;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectInfoDTOConverter {

    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);

    SubjectInfoBO dto2bo(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO bo2dto(SubjectInfoBO subjectInfoBO);


    List<SubjectInfoBO> dtos2bos(List<SubjectCategoryDTO> dtoList);

    List<SubjectInfoDTO> bos2dtos(List<SubjectInfoBO> boList);
}
