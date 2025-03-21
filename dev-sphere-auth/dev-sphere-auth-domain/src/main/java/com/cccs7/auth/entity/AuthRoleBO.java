package com.cccs7.auth.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRoleBO)
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/02
 */
@Data
public class AuthRoleBO implements Serializable {
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

