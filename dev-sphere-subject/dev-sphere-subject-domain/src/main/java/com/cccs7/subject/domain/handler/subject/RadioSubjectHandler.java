package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.convert.RadioSubjectConverter;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.infra.basic.entity.SubjectRadio;
import com.cccs7.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * 单选题目处理
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */
@Component
public class RadioSubjectHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjecInfoBo) {
        //实际的插入处理
        LinkedList<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjecInfoBo.getOptionList().forEach(option -> {
            SubjectRadio radio = RadioSubjectConverter.INSTANCE.bo2po(option);
            radio.setSubjectId(subjecInfoBo.getId());
            subjectRadioList.add(radio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }
}
