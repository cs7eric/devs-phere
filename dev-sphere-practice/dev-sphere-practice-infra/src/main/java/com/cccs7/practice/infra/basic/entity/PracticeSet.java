package com.cccs7.practice.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 套题信息表(PracticeSet)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
public class PracticeSet implements Serializable {
    private static final long serialVersionUID = -59379613019245942L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public Integer getSetType() {
        return setType;
    }

    public void setSetType(Integer setType) {
        this.setType = setType;
    }

    public Integer getSetHeat() {
        return setHeat;
    }

    public void setSetHeat(Integer setHeat) {
        this.setHeat = setHeat;
    }

    public String getSetDesc() {
        return setDesc;
    }

    public void setSetDesc(String setDesc) {
        this.setDesc = setDesc;
    }

    public Long getPrimaryCategoryId() {
        return primaryCategoryId;
    }

    public void setPrimaryCategoryId(Long primaryCategoryId) {
        this.primaryCategoryId = primaryCategoryId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}

