package com.cccs7.wx.enums;

/**
 * 微信消息类型枚举
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
public enum WxChatMsgTypeEnum {


    SUBSCRIBE("event.subscribe", "用户关注事件"),
    TEXT_MSG("text","接收用户文本信息");


    private String msgType;

    private String desc;

    WxChatMsgTypeEnum(String msgType, String desc) {
        this.msgType = msgType;
        this.desc = desc;
    }

    public static WxChatMsgTypeEnum getByMsgType(String msgType) {
        for (WxChatMsgTypeEnum wxChatMsgTypeEnum : WxChatMsgTypeEnum.values()) {
            if (wxChatMsgTypeEnum.msgType.equals(msgType)) {
                return wxChatMsgTypeEnum;
            }
        }
        return null;
    }
}
