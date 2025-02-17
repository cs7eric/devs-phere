package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.entity.SubjectOptionBO;


/**
 * 题目类型处理接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */
public interface SubjectTypeHandler {

    /**
     * 获取处理程序类型
     *
     * @return {@link SubjectInfoTypeEnum }
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目插入
     */
    void add(SubjectInfoBO subjecInfoBo);

    /**
     * 实际的题目查询
     *
     * @param subjectId 题目id
     * @return {@link SubjectOptionBO }
     */
    SubjectOptionBO query(int subjectId);
}
