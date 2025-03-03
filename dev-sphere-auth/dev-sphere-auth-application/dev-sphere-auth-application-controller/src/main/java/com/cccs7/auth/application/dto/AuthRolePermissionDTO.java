package com.cccs7.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 22:37:16
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    private static final long serialVersionUID = 852352407548257318L;

    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 权限id
     */
    private Long permissionId;

    private List<Long> permissionIdList;


}

