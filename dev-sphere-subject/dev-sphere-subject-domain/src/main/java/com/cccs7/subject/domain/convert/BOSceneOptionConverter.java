package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectOptionBO;
import com.cccs7.subject.domain.entity.SubjectSceneBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BOSceneOptionConverter {


    BOSceneOptionConverter INSTANCE = Mappers.getMapper(BOSceneOptionConverter.class);

    SubjectSceneBO optionBOConvertSceneBO(SubjectOptionBO subjectOptionBO);

    List<SubjectSceneBO> optionBOConvertSceneBOList( List<SubjectOptionBO>  subjectOptionBOList);

    SubjectOptionBO sceneBOConvertOptionBO(SubjectSceneBO subjectSceneBO);

    List<SubjectOptionBO> sceneBOConvertOptionBOList(List<SubjectSceneBO> subjectSceneBOList);
}
