package com.cccs7.auth.service;

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
}
