package com.cccs7.auth.basic.service;

import com.cccs7.auth.basic.entity.AuthUser;

/**
 * 用户信息表(AuthUser)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-01 19:37:26
 */
public interface AuthUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthUser queryById(Long id);



    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer insert(AuthUser authUser);

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    AuthUser update(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
