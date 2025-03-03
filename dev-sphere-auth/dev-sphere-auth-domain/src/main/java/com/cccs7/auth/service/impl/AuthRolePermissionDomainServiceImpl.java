package com.cccs7.auth.service.impl;

import com.cccs7.auth.basic.entity.AuthRolePermission;
import com.cccs7.auth.basic.service.AuthRolePermissionService;
import com.cccs7.auth.entity.AuthPermissionBO;
import com.cccs7.auth.entity.AuthRolePermissionBO;
import com.cccs7.auth.enums.IsDeletedFlagEnum;
import com.cccs7.auth.service.AuthRolePermissionDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * 身份验证角色权限域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/03
 */
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {

        LinkedList<AuthRolePermission> authRolePermissionList = new LinkedList<>();
        Long roleId = authRolePermissionBO.getRoleId();
        authRolePermissionBO.getPermissionIdList().forEach( permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(roleId);
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            authRolePermissionList.add(authRolePermission);
        });

        int count = authRolePermissionService.batchInsert(authRolePermissionList);
        return count > 0;
    }
}
