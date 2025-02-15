package com.cccs7.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * 学科分类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/05
 */
@Data
public class SubjectCategory implements Serializable {
    private static final long serialVersionUID = -62345843970655741L;
/**
     * 主键
     */
    private Long id;
/**
     * 分类名称
     */
    private String categoryName;
/**
     * 分类类型
     */
    private Integer categoryType;
/**
     * 图标连接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Long parentId;
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
     * 是否删除 0: 未删除 1: 已删除
     */
    private Integer isDeleted;

}

