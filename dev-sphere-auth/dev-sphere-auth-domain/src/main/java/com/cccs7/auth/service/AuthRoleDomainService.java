package com.cccs7.auth.service;

import com.cccs7.auth.entity.AuthRoleBO;
import org.springframework.stereotype.Service;

/**
 * 鉴权角色域服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Service
public interface AuthRoleDomainService {


    /**
     * 添加
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    Boolean add(AuthRoleBO authRoleBO);

    /**
     * 更新
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    Boolean update(AuthRoleBO authRoleBO);

    /**
     * 删除角色 - 逻辑删除
     *
     * @param authRoleBO Auth role bo
     * @return {@link Boolean }
     */
    Boolean delete(AuthRoleBO authRoleBO);
}
