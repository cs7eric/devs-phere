package com.cccs7.circle.infra.basic.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章标签关系表(ShareArticleLabelMapping)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 22:48:20
 */
@Data
public class ShareArticleLabelMapping implements Serializable {
    private static final long serialVersionUID = 337483235463238038L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 文章id
     */
    private Long articleId;
    /**
     * 标签id
     */
    private String labelName;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改人
     */
    private String updateBy;
    /**
     * 修改时间
     */
    private Date updateTime;

    private Integer isDeleted;

}

