package com.cccs7.circle.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 动态信息(ShareMoment)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:36:11
 */
@Data
public class ShareMoment implements Serializable {
    private static final long serialVersionUID = 317792557913821115L;
    /**
     * 动态ID
     */
    private Long id;
    /**
     * 作者id
     */
    private String userName;
    /**
     * 圈子ID
     */
    private Long circleId;


    /**
     * 动态标题
     */
    private String momentTitle;


    /**
     * 动态内容
     */
    private String content;
    /**
     * 动态图片内容
     */
    private String picUrls;
    /**
     * 收藏数
     */
    private Integer collectCount;
    /**
     * 点赞数
     */
    private Integer likeCount;
    /**
     * 回复数
     */
    private Integer replyCount;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否被删除 0为删除 1已删除
     */
    private Integer isDeleted;

}

