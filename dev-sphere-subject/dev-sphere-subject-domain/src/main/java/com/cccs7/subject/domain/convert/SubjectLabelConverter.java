package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 题目标签转换器
 *
 * @author Cs7er
 * @date 2025/02/15
 */
@Mapper
public interface SubjectLabelConverter {


    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel bo2po(SubjectLabelBO subjectLabelBO);

    SubjectLabel po2bo(SubjectLabel subjectLabel);

    List<SubjectLabelBO> pos2bos(List<SubjectLabel> subjectLabelDTOList);

    List<SubjectLabel> bos2pos(List<SubjectLabelBO> subjectLabelBOList);


}
