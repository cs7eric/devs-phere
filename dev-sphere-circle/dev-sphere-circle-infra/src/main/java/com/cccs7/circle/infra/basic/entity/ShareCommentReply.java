package com.cccs7.circle.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论及回复信息(ShareCommentReply)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public class ShareCommentReply implements Serializable {
    private static final long serialVersionUID = -92431593948652281L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Integer getReplyType() {
        return replyType;
    }

    public void setReplyType(Integer replyType) {
        this.replyType = replyType;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getToUserAuthor() {
        return toUserAuthor;
    }

    public void setToUserAuthor(Integer toUserAuthor) {
        this.toUserAuthor = toUserAuthor;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

    public Integer getReplayAuthor() {
        return replayAuthor;
    }

    public void setReplayAuthor(Integer replayAuthor) {
        this.replayAuthor = replayAuthor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLeafNode() {
        return leafNode;
    }

    public void setLeafNode(String leafNode) {
        this.leafNode = leafNode;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}

