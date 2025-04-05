package com.cccs7.circle.handler;

import com.cccs7.circle.common.enums.InteractionTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交互处理程序工厂
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/04/05
 */
@Component
public class InteractionHandlerFactory
        implements InitializingBean {

    @Resource
    private List<InteractionHandler> handlerList;


    private Map<InteractionTypeEnum, InteractionHandler> handlerMap =  new HashMap<>();

    public InteractionHandler getHandler(int interactionType){
        InteractionTypeEnum interactionTypeEnum = InteractionTypeEnum.getByCode(interactionType);
        return handlerMap.get(interactionTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        handlerList.forEach(handler -> {
            handlerMap.put(handler.getHandlerType(), handler);
        });
    }
}
