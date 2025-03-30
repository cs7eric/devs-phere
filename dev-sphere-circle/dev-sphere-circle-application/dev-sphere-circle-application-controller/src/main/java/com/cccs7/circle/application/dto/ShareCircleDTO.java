package com.cccs7.circle.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 圈子信息(ShareCircle)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:34:44
 */
@Data
public class ShareCircleDTO implements Serializable {
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

    private String circleIntro;
    /**
     * 圈子图片
     */
    private String icon;

}

