package com.cccs7.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签bo
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/05
 */
@Data
public class SubjectLabelBO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;
}
