package com.cccs7.auth.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.cccs7.auth.basic.entity.*;
import com.cccs7.auth.basic.redis.RedisUtil;
import com.cccs7.auth.basic.service.*;
import com.cccs7.auth.constants.AuthConstant;
import com.cccs7.auth.convert.AuthUserBOConverter;
import com.cccs7.auth.entity.AuthUserBO;
import com.cccs7.auth.enums.AuthUserStatusEnum;
import com.cccs7.auth.enums.IsDeletedFlagEnum;
import com.cccs7.auth.service.AuthUserDomainService;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 鉴权用户域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Service
public class AuthUserDomainServiceImpl implements AuthUserDomainService {
    private String salt = "cccs7";
    private final String AUTH_PERMISSION_PREFIX = "auth.permission";
    private final String AUTH_ROLE_PREFIX = "auth.role";
    private static final String LOGIN_PREFIX = "loginCode";

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    private AuthUserRoleService authUserRoleService;

    @Resource
    private AuthRolePermissionService authRolePermissionService;

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 注册
     *
     * @param authUserBO 授权用户bo
     * @return {@link Boolean }
     */
    @Override
    @SneakyThrows
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AuthUserBO authUserBO) {

        AuthUser existAuthUser = new AuthUser();
        existAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUser = authUserService.queryByCondition(existAuthUser);
        if (existUser.size() > 0) {
            return true;
        }
        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(authUser.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5BySalt(authUser.getPassword(), salt));
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(authUser.getAvatar())) {
            authUser.setAvatar("https://cs7eric-image.oss-cn-hangzhou.aliyuncs.com/images/image-20250314220820953.png");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(authUser.getNickName())) {
            authUser.setNickName("用户" + authUser.getUserName());
        }
        authUser.setStatus(AuthUserStatusEnum.OPEN.getCode());
        authUser.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authUserService.insert(authUser);
        //建立一个初步的角色的关联
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole roleResult = authRoleService.queryByCondition(authRole);
        Long roleId = roleResult.getId();
        Long userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        authUserRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        authUserRoleService.insert(authUserRole);

        String roleKey = redisUtil.buildKey(AUTH_ROLE_PREFIX, authUser.getUserName());
        LinkedList<AuthRole> roleList = new LinkedList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(roleId);
        List<AuthRolePermission> authRolePermissionsList
                = authRolePermissionService.queryByCondition(authRolePermission);
        List<Long> permissionIdList
                = authRolePermissionsList.stream().map(AuthRolePermission::getPermissionId)
                .collect(Collectors.toList());

        //把当前用户的角色和权限都存到 redis 中

        List<AuthPermission> authPermissionList
                = authPermissionService.queryByPermissionIdList(permissionIdList);
        String permissionKey = redisUtil.buildKey(AUTH_PERMISSION_PREFIX, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(authPermissionList));


        return count > 0;
    }


    /**
     * 更新用户信息
     *
     * @param authUserBO 授权用户bo
     * @return {@link Boolean }
     */
    @Override
    public Boolean update(AuthUserBO authUserBO) {

        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        Integer update = authUserService.updateByUserName(authUser);
        return update > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        authUser.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return authUserService.delete(authUser) > 0;
    }

    @Override
    public Boolean changeStatus(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        Integer status = authUser.getStatus();
        authUser.setStatus(status);
        return authUserService.changeStatus(authUser) > 0;
    }

    @Override
    public AuthUserBO getUserInfo(AuthUserBO authUserBO) {
        AuthUser authUser = new AuthUser();
        authUser.setUserName(authUserBO.getUserName());
        List<AuthUser> authUserList = authUserService.queryByCondition(authUser);
        if (CollectionUtils.isEmpty(authUserList)) return new AuthUserBO();
        AuthUser user = authUserList.get(0);
        return AuthUserBOConverter.INSTANCE.po2bo(user);
    }


    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) return null;
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        return StpUtil.getTokenInfo();
    }

    /**
     * 查询用户列表
     *
     * @param authUserBO 授权用户bo
     * @return {@link List }<{@link AuthUserBO }>
     */
    @Override
    public List<AuthUserBO> getUserList(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        authUser.setIsDeleted(0);
        List<AuthUser> authUserList = authUserService.queryByCondition(authUser);
        return AuthUserBOConverter.INSTANCE.pos2bos(authUserList);
    }

    /**
     * 找到用户
     *
     * @param authUserBO 授权用户bo
     * @return {@link List }<{@link AuthUserBO }>
     */
    @Override
    public List<AuthUserBO> findUser(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.bo2po(authUserBO);
        List<AuthUser> authUserList = authUserService.findUserByNickName(authUser);
        return AuthUserBOConverter.INSTANCE.pos2bos(authUserList);
    }
}
