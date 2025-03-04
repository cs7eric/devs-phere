package com.cccs7.wx.handler;

import com.cccs7.wx.enums.WxChatMsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订阅MSG处理程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
@Slf4j
@Component
public class SubscribeMsgHandler implements WxChatMsgHandler {


    @Override
    public WxChatMsgTypeEnum getMsgType() {
        return WxChatMsgTypeEnum.SUBSCRIBE;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("触发用户关注事件！");
        String fromUserName = messageMap.get("FromUserName");
        String toUserName = messageMap.get("ToUserName");
        String subscribeContent = "Thanks For Following！\nWelcome to DevSphere\n";
        String content = "<xml>\n" +
                "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[" + subscribeContent + "]]></Content>\n" +
                "</xml>";
        return content;
    }
}
