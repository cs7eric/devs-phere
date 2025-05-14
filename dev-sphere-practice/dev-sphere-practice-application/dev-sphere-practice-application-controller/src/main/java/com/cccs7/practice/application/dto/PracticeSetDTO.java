package com.cccs7.practice.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 套题信息表 dto
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
@Data
public class PracticeSetDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 套题名称
     */
    private String setName;

    /**
     * 套题类型 1实时生成 2预设套题
     */
    private Integer setType;

    /**
     * 热度
     */
    private Integer setHeat;

    /**
     * 套题描述
     */
    private String setDesc;

    /**
     * 大类id
     */
    private Long primaryCategoryId;

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

