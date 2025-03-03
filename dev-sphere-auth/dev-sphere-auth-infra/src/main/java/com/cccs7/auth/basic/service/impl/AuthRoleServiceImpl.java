package com.cccs7.auth.basic.service.impl;

import com.cccs7.auth.basic.entity.AuthRole;
import com.cccs7.auth.basic.mapper.AuthRoleDao;
import com.cccs7.auth.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthRole)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 16:47:15
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRole queryById(Long id) {
        return this.authRoleDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRole insert(AuthRole authRole) {
        this.authRoleDao.insert(authRole);
        return authRole;
    }

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    @Override
    public int update(AuthRole authRole) {
        return this.authRoleDao.update(authRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRoleDao.deleteById(id) > 0;
    }


    @Override
    public int add(AuthRole authRole) {
        return this.authRoleDao.insert(authRole);
    }


    @Override
    public AuthRole queryByCondition(AuthRole authRole) {
        return this.authRoleDao.queryByCondition(authRole);
    }
}
