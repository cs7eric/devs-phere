package com.cccs7.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 场景、面试题信息表(SubjectScene)实体类 - BO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-12 16:24:20
 */
@Data
public class SubjectSceneBO implements Serializable {

    /**
     * 提示序列
     */
    private Long suggestRank;
    /**
     * 提示内容
     */
    private String suggestContent;

}

