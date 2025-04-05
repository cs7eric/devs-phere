package com.cccs7.circle.handler;

import com.alibaba.fastjson.JSON;
import com.cccs7.circle.bo.InteractionBO;
import com.cccs7.circle.common.enums.InteractionTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 动态处理程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/04/05
 */
@Slf4j
@Component
public class MomentHandler implements InteractionHandler{
    @Override
    public InteractionTypeEnum getHandlerType() {
        return InteractionTypeEnum.MOMENT;
    }

    @Override
    public void like(InteractionBO interactionBO) {
        if (log.isInfoEnabled()) {
            log.info("MomentHandler.like.bo:{}", JSON.toJSONString(interactionBO));
        }
    }

    @Override
    public void collect(InteractionBO interactionBO) {
        if (log.isInfoEnabled()) {
            log.info("MomentHandler.collect.bo:{}", JSON.toJSONString(interactionBO));
        }
    }

    @Override
    public void comment(InteractionBO interactionBO) {
        if (log.isInfoEnabled()) {
            log.info("MomentHandler.comment.bo:{}", JSON.toJSONString(interactionBO));
        }
    }

    @Override
    public void join(InteractionBO interactionBO) {
       return;
    }
}
