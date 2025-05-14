package com.cccs7.subject.domain.convert;

import com.cccs7.subject.domain.entity.SubjectLikedBO;
import com.cccs7.subject.infra.basic.entity.SubjectLiked;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 题目点赞表 bo转换器
 *
 * @author cccs7
 * @since 2025-05-14 23:10:16
 */
@Mapper
public interface SubjectLikedBOConverter {

    SubjectLikedBOConverter INSTANCE = Mappers.getMapper(SubjectLikedBOConverter.class);

    SubjectLiked convertBOToEntity(SubjectLikedBO subjectLikedBO);

}
