package com.cccs7.wx.handler;

import com.cccs7.wx.enums.WxChatMsgTypeEnum;

import java.util.Map;

public interface WxChatMsgHandler {


    /**
     * 查询信息类型
     *
     * @return {@link WxChatMsgTypeEnum }
     */
    WxChatMsgTypeEnum getMsgType();


    /**
     * 处理信息
     *
     * @param messageMap 消息映射
     * @return {@link String }
     */
    String dealMsg(Map<String, String> messageMap);
}
