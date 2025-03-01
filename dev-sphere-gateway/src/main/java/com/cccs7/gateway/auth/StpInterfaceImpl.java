package com.cccs7.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.cccs7.gateway.redis.RedisUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private final String AUTH_PERMISSION_PREFIX = "auth.permission";
    private final String AUTH_ROLE_PREFIX = "auth.role";


    /**
     * 获取权限列表
     *
     * @param loginId   登录ID
     * @param loginType 登录类型
     * @return {@link List }<{@link String }>
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        return getAuthList(loginId.toString(), AUTH_PERMISSION_PREFIX);

    }

    /**
     * 获取角色列表
     *
     * @param loginId   登录ID
     * @param loginType 登录类型
     * @return {@link List }<{@link String }>
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuthList(loginId.toString(), AUTH_ROLE_PREFIX);
    }


    /**
     * 获取授权列表
     *
     * @param loginId 登录ID
     * @param prefix  前缀
     * @return {@link List }<{@link String }>
     */
    private List<String> getAuthList(String loginId, String prefix) {
        String authKey = redisUtil.buildKey(prefix, loginId.toString());
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)) return Collections.emptyList();

        return new Gson().fromJson(authValue, List.class);
    }

}
