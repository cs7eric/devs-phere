package com.cccs7.circle.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章信息(ShareArticle)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 19:39:19
 */
@Data
public class ShareArticle implements Serializable {
    private static final long serialVersionUID = -46596802729074062L;
    /**
     * 文章ID
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
     * 文章标题
     */
    private String title;
    /**
     * 文章内容
     */
    private String content;
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
     * 是否被删除 0为未删除 1已删除
     */
    private Integer isDeleted;
}

