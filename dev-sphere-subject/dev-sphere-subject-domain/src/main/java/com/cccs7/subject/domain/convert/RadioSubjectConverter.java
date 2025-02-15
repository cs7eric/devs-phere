package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectAnswerBO;
import com.cccs7.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RadioSubjectConverter {

    RadioSubjectConverter INSTANCE = Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio bo2po(SubjectAnswerBO subjectAnswerBO);

    SubjectAnswerBO po2bo(SubjectRadio subjectRadio);

    List<SubjectAnswerBO> pos2bos(List<SubjectRadio> subjectRadioList);

}
