package com.cccs7.auth.service.impl;

import com.cccs7.auth.basic.entity.AuthUser;
import com.cccs7.auth.basic.service.AuthUserService;
import com.cccs7.auth.convert.AuthUserBOConverter;
import com.cccs7.auth.entity.AuthUserBO;
import com.cccs7.auth.enums.AuthUserStatusEnum;
import com.cccs7.auth.enums.IsDeletedFlagEnum;
import com.cccs7.auth.service.AuthUserDomainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 鉴权用户域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Service
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Override
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.insert(authUser);
        //建立一个初步的角色的关联
        //把当前用户的角色和权限都存到 redis 中

        return count > 0;

    }
}
