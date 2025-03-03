package com.cccs7.auth.basic.service;

import com.cccs7.auth.basic.entity.AuthRolePermission;

import java.util.LinkedList;

/**
 * 角色权限关联表(AuthRolePermission)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 22:37:16
 */
public interface AuthRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Long id);


    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission insert(AuthRolePermission authRolePermission);

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入
     *
     * @param authRolePermissionList 身份验证角色权限列表
     * @return int
     */
    int batchInsert(LinkedList<AuthRolePermission> authRolePermissionList);
}
