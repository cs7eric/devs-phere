package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.entity.SubjectOptionBO;
import com.cccs7.subject.infra.basic.entity.SubjectBrief;
import com.cccs7.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题目处理
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */
@Component
public class BriefSubjectHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    /**
     * 实际的插入处理
     *
     * @param subjecInfoBo 主题信息
     */
    @Override
    public void add(SubjectInfoBO subjecInfoBo) {
        //
    }

    /**
     * 实际的查询处理
     *
     * @param subjectId 题目id
     * @return {@link SubjectOptionBO }
     */
    @Override
    public SubjectOptionBO query(int subjectId) {

        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO optionBO = new SubjectOptionBO();
        optionBO.setSubjectAnswer(result.getSubjectAnswer());
        return optionBO;
    }
}
