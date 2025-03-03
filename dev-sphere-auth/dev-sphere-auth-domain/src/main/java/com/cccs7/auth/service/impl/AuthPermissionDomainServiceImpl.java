package com.cccs7.auth.service.impl;

import com.cccs7.auth.basic.entity.AuthPermission;
import com.cccs7.auth.basic.service.AuthPermissionService;
import com.cccs7.auth.convert.AuthPermissionBOConverter;
import com.cccs7.auth.entity.AuthPermissionBO;
import com.cccs7.auth.enums.IsDeletedFlagEnum;
import com.cccs7.auth.service.AuthPermissionDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/03
 */
@Slf4j
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {


    @Resource
    private AuthPermissionService authPermissionService;

    /**
     * 添加权限
     *
     * @param authPermissionBO 授权许可
     * @return {@link Boolean }
     */
    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {

        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.bo2po(authPermissionBO);
        int add = authPermissionService.insert(authPermission);
        return add > 0;
    }


    /**
     * 删除权限信息
     *
     * @param authPermissionBO 授权许可
     * @return {@link Boolean }
     */
    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.bo2po(authPermissionBO);
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int delete = authPermissionService.update(authPermission);
        return delete > 0;
    }

    /**
     * 获取用户权限
     *
     * @param authPermissionBO 身份验证权限薄
     * @return {@link AuthPermissionBO }
     */
    @Override
    public AuthPermissionBO getPermission(AuthPermissionBO authPermissionBO) {
        return null;
    }

    /**
     * 更新权限信息
     *
     * @param authPermissionBO 身份验证权限薄
     * @return {@link Boolean }
     */
    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.bo2po(authPermissionBO);
        int update = authPermissionService.update(authPermission);
        return update > 0;
    }
}
