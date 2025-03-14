package com.cccs7.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.cccs7.auth.entity.AuthUserBO;
import org.springframework.stereotype.Service;

/**
 * 授权用户域服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Service
public interface AuthUserDomainService {


    /**
     * 用户注册
     *
     * @param authUserBO 授权用户bo
     * @return {@link AuthUserBO }
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 更新
     *
     * @param authUserBO 授权用户bo
     * @return {@link Boolean }
     */
    Boolean update(AuthUserBO authUserBO);

    /**
     * 删除用户
     *
     * @param authUserBO 授权用户bo
     * @return {@link Integer }
     */
    Boolean delete(AuthUserBO authUserBO);

    /**
     * 用户启用/禁用
     *
     * @param authUserBO 授权用户bo
     * @return {@link Boolean }
     */
    Boolean changeStatus(AuthUserBO authUserBO);

    /**
     * 获取用户信息
     *
     * @param authUserBO 授权用户bo
     * @return {@link AuthUserBO }
     */
    AuthUserBO getUserInfo(AuthUserBO authUserBO);

    /**
     * 登录
     *
     * @param validCode 有效代码
     * @return {@link SaTokenInfo }
     */
    SaTokenInfo doLogin(String validCode);
}
