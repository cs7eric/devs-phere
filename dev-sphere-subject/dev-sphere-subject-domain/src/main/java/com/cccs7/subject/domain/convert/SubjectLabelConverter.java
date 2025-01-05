package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectLabelConverter {


    SubjectLabelConverter INSTANCE =  Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel bo2po(SubjectLabelBO subjectLabelBO);
}
