package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectSceneBO;
import com.cccs7.subject.infra.basic.entity.SubjectScene;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SceneSubjectConverter {

    SceneSubjectConverter INSTANCE = Mappers.getMapper(SceneSubjectConverter.class);

    SubjectScene bo2po(SubjectSceneBO subjectSceneBO);

    SubjectSceneBO po2bo(SubjectScene subjectScene);

    List<SubjectSceneBO> pos2bos(List<SubjectScene> subjectScenes);

}