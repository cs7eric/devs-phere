package com.cccs7.circle.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 敏感词表(SensitiveWords)DTO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:34:44
 */
@Data
public class SensitiveWordsDTO implements Serializable {

    /**
     * id
     */
    private Long id;
/**
     * 内容
     */
    private String words;
/**
     * 1=黑名单 2=白名单
     */
    private Integer type;
/**
     * 是否被删除 0为删除 1已删除
     */
    private Integer isDeleted;

}

