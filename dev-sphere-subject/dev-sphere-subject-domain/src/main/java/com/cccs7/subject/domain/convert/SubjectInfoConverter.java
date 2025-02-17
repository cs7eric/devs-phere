package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.entity.SubjectOptionBO;
import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * SubjectInfoConverter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/06
 */
@Mapper
public interface SubjectInfoConverter {


    SubjectInfoConverter INSTANCE =  Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo bo2po(SubjectInfoBO subjectLabelBO);

    SubjectInfoBO po2bo(SubjectInfo subjectInfo);

    SubjectInfoBO optionAndInfo2bo(SubjectOptionBO subjectOptionBO, SubjectInfo subjectInfo);

    List<SubjectInfoBO> pos2bos(List<SubjectInfo> subjectLabelDTOList);

    List<SubjectInfo> bos2pos(List<SubjectInfoBO> SubjectInfoBOList);




}
