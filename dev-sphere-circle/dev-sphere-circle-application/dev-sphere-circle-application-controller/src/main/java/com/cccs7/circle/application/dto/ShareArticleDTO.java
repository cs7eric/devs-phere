package com.cccs7.circle.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 文章信息(ShareArticle)DTO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 19:39:19
 */
@Data
public class ShareArticleDTO implements Serializable {
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
     * 是否被删除 0为未删除 1已删除
     */
    private Integer isDeleted;

    private List<String> labelList;

}

