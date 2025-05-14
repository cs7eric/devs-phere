package com.cccs7.practice.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 套题内容表 dto
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
@Data
public class PracticeSetDetailDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 题目id
     */
    private Long subjectId;

    /**
     * 题目类型
     */
    private Integer subjectType;

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

