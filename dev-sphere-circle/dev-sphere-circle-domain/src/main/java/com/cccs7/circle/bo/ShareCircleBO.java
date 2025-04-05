package com.cccs7.circle.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 圈子信息(ShareCircle)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:34:44
 */
@Data
public class ShareCircleBO implements Serializable {
    private static final long serialVersionUID = -66087068929731871L;
    /**
     * 圈子ID
     */
    private Long id;
    /**
     * 父级ID,-1为大类
     */
    private Long parentId;
    /**
     * 分类id
     */
    private Long categoryId;

    private Integer memberCount;
    /**
     * 圈子名称
     */
    private String circleName;

    /**
     * 用户ID
     */
    private Long userId;


    /**
     * 用户名
     */
    private String userName;

    /**
     * 圈子介绍
     */
    private String circleIntro;
    /**
     * 圈子图片
     */
    private String icon;
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

