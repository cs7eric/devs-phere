package com.cccs7.circle.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 圈子成员信息(ShareCircleMember)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:09:18
 */
@Data
public class ShareCircleMember implements Serializable {
    private static final long serialVersionUID = 321419416165706028L;
/**
     * ID
     */
    private Long id;
/**
     * 圈子id
     */
    private Long circleId;
/**
     * 用户id
     */
    private Long userId;
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

