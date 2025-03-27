package com.cccs7.circle.infra.basic.entity;

import java.io.Serializable;

/**
 * 敏感词表(SensitiveWords)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public class SensitiveWords implements Serializable {
    private static final long serialVersionUID = 696059556568186468L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}

