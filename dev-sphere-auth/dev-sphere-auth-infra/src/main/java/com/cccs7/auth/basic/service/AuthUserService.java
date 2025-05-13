package com.cccs7.auth.basic.service;

import com.cccs7.auth.basic.entity.AuthUser;

import java.util.List;

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
    Integer update(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 按用户名更新
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    Integer updateByUserName(AuthUser authUser);

    /**
     * 删除用户 - 逻辑删除
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    Integer delete(AuthUser authUser);

    /**
     * 用户启用/禁用
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    Integer changeStatus(AuthUser authUser);

    /**
     * 按条件查询
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> queryByCondition(AuthUser authUser);


    /**
     * 获取所有用户
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> queryAll(AuthUser authUser);

    /**
     * 通过昵称查找用户
     *
     * @param nickName 尼克名字
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> findUserByNickName(AuthUser authUser);
}
