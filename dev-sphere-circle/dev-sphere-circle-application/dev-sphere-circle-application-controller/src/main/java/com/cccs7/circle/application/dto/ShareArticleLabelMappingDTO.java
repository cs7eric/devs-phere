package com.cccs7.circle.application.dto;

import lombok.Data;

/**
 * 文章标签关系表(ShareArticleLabelMapping)DTO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 22:48:20
 */
@Data
public class ShareArticleLabelMappingDTO {
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

    private Integer isDeleted;

}

