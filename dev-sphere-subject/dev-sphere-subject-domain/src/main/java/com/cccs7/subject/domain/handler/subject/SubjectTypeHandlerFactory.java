package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型工厂
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */

@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> handlerList;
    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap = new HashMap<>();

    /**
     * 获取对应处理类
     *
     * @param subjectType 题目类型
     * @return {@link SubjectTypeHandler }
     */
    public SubjectTypeHandler getHandler(int subjectType) {
        SubjectInfoTypeEnum typeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        return handlerMap.get(typeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        handlerList.forEach(handler -> {
            handlerMap.put(handler.getHandlerType(), handler);
        });
    }
}
