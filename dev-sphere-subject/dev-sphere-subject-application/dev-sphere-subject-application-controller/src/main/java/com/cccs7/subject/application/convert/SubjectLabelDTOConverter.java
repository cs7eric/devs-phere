package com.cccs7.subject.application.convert;

import com.cccs7.subject.application.dto.SubjectLabelDTO;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE =  Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO dto2bo(SubjectLabelDTO subjectLabelDTO);

    SubjectLabelDTO bo2dto(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> dtos2bos(List<SubjectLabelDTO> subjectLabelDTOList);

    List<SubjectLabelDTO> bos2dtos(List<SubjectLabelBO> subjectLabelBOList);

}
