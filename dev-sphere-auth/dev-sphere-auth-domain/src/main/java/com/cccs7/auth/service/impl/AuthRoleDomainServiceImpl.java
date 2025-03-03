package com.cccs7.auth.service.impl;

import com.cccs7.auth.basic.entity.AuthRole;
import com.cccs7.auth.basic.service.AuthRoleService;
import com.cccs7.auth.convert.AuthRoleBOConverter;
import com.cccs7.auth.entity.AuthRoleBO;
import com.cccs7.auth.enums.IsDeletedFlagEnum;
import com.cccs7.auth.service.AuthRoleDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 鉴权角色域服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    /**
     * 添加
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    @Override
    public Boolean add(AuthRoleBO authRoleBO) {

        AuthRole authRole = AuthRoleBOConverter.INSTANCE.bo2po(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count  = authRoleService.add(authRole);
        return count > 0;
    }

    /**
     * 更新
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.bo2po(authRoleBO);
        int update  = authRoleService.update(authRole);
        return update > 0;
    }


    /**
     * 删除
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.bo2po(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int delete = authRoleService.update(authRole);
        return delete > 0;
    }
}
