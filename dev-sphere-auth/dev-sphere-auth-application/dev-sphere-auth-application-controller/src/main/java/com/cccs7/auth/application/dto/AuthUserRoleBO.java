package com.cccs7.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色表(AuthUserRole)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 22:37:52
 */
@Data
public class AuthUserRoleBO implements Serializable {
    private static final long serialVersionUID = -30171243684255960L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;
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

    private Integer isDeleted;

}

