package com.cccs7.wx.factory;

import com.cccs7.wx.enums.WxChatMsgTypeEnum;
import com.cccs7.wx.handler.WxChatMsgHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信消息工厂
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
@Component
public class WxChatMsgFactory implements InitializingBean {

    @Resource
    private List<WxChatMsgHandler> wxChatMsgHandlerList;

    private Map<WxChatMsgTypeEnum, WxChatMsgHandler> handlerMap = new HashMap<>();


    public WxChatMsgHandler getHandlerByMsgType(String msgType) {
        WxChatMsgTypeEnum type = WxChatMsgTypeEnum.getByMsgType(msgType);
        return handlerMap.get(type);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        for (WxChatMsgHandler wxChatMsgHandler : wxChatMsgHandlerList) {
            handlerMap.put(wxChatMsgHandler.getMsgType(), wxChatMsgHandler);
        }
    }
}
