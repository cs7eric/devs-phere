package com.cccs7.auth.service;

import com.cccs7.auth.entity.AuthRolePermissionBO;

public interface AuthRolePermissionDomainService {

    /**
     * 新增角色权限关联关系
     *
     * @param authRolePermissionBO 身份验证角色权限薄
     * @return {@link Boolean }
     */
    Boolean add(AuthRolePermissionBO authRolePermissionBO);
}
