package com.cccs7.circle.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 消息表(ShareMessage)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:34:44
 */
@Data
public class ShareMessageDTO implements Serializable {
    private static final long serialVersionUID = -21457154535086522L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 来自人
     */
    private String fromId;
    /**
     * 送达人
     */
    private String toId;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 是否被阅读 1是 2否
     */
    private Integer isRead;

}

