package com.cccs7.practice.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 练习表 dto
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
@Data
public class PracticeInfoDTO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 套题id
     */
    private Long setId;

    /**
     * 是否完成 1完成 0未完成
     */
    private Integer completeStatus;

    /**
     * 用时
     */
    private String timeUse;

    /**
     * 交卷时间
     */
    private Date submitTime;

    /**
     * 正确率
     */
    private BigDecimal correctRate;

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

