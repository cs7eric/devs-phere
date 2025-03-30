package com.cccs7.circle.bo;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论及回复信息(ShareCommentReply)BO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:34:44
 */
@Data
public class ShareCommentReplyBO implements Serializable {
    private static final long serialVersionUID = 166617827351730570L;
/**
     * 评论ID
     */
    private Long id;
/**
     * 原始动态ID
     */
    private Integer momentId;
/**
     * 回复类型 1评论 2回复
     */
    private Integer replyType;
/**
     * 评论目标id
     */
    private Long toId;
/**
     * 评论人
     */
    private String toUser;
/**
     * 评论人是否作者 1=是 0=否
     */
    private Integer toUserAuthor;
/**
     * 回复目标id
     */
    private Long replyId;
/**
     * 回复人
     */
    private String replyUser;
/**
     * 回复人是否作者 1=是 0=否
     */
    private Integer replayAuthor;
/**
     * 内容
     */
    private String content;
/**
     * 图片内容
     */
    private String picUrls;

    private Integer parentId;

    private String leafNode;

    private String children;

    private String rootNode;
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

