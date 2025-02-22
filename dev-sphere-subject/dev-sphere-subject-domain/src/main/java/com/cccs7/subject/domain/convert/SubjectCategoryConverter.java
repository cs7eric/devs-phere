package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectCategoryBO;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory bo2po(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategory> bos2pos(List<SubjectCategoryBO> boList);

    List<SubjectCategoryBO> pos2bos(List<SubjectCategory> poList);

}
