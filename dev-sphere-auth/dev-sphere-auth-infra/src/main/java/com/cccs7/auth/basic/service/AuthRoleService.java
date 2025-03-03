package com.cccs7.auth.basic.service;

import com.cccs7.auth.basic.entity.AuthRole;

/**
 * (AuthRole)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 16:47:15
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Long id);



    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    AuthRole insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    int update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 添加
     *
     * @param authRole 身份验证作用
     * @return int
     */
    int add(AuthRole authRole);

    /**
     * 按条件查询
     *
     * @param authRole 身份验证作用
     * @return {@link AuthRole }
     */
    AuthRole queryByCondition(AuthRole authRole);
}
