package com.cccs7.subject.application.convert;

import com.cccs7.subject.application.dto.SubjectCategoryDTO;
import com.cccs7.subject.domain.entity.SubjectCategoryBO;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBO dto2bo(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryBO> dtos2bos(List<SubjectCategoryDTO> dtoList);
}
