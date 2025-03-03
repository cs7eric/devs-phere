package com.cccs7.auth.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 16:47:15
 */
@Data
public class AuthRole implements Serializable {
    private static final long serialVersionUID = -23041093358129072L;

    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色唯一标识
     */
    private String roleKey;
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
     * 是否被删除 0未删除 1已删除
     */
    private Integer isDeleted;


}

