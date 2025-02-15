package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import org.springframework.stereotype.Component;

/**
 * 多选题目处理
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */

@Component
public class MultipleSubjectHandler implements SubjectTypeHandler{

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjecInfoBo) {
        //实际的插入处理
    }
}
