package com.cccs7.wx.handler;

import com.cccs7.wx.enums.WxChatMsgTypeEnum;
import com.cccs7.wx.redis.RedisUtil;
import com.cccs7.wx.utils.CaptchaGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 接收文本MSG处理程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
@Slf4j
@Component
public class ReceiveTextMsgHandler implements WxChatMsgHandler{

    private static final String KEY_WORD = "验证码";

    private static final String LOGIN_PREFIX = "loginCode";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public WxChatMsgTypeEnum getMsgType() {
        return WxChatMsgTypeEnum.TEXT_MSG;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("接收到文本消息事件");
        String content = messageMap.get("Content");
        if (!KEY_WORD.equals(content)) {
            return "";
        }
        String fromUserName = messageMap.get("FromUserName");
        String toUserName = messageMap.get("ToUserName");

        String validCode = CaptchaGenerator.generate();
        String numKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        redisUtil.setNx(numKey, fromUserName, 5L, TimeUnit.MINUTES);
        String numContent = "您当前的验证码是: 【" + validCode + "】 \n5分钟内有效";
        String replyContent = "<xml>\n" +
                "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[" + numContent + "]]></Content>\n" +
                "</xml>";

        return replyContent;
    }
}
