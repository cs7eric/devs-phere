package com.cccs7.auth.basic.service.impl;

import com.cccs7.auth.basic.entity.AuthPermission;
import com.cccs7.auth.basic.mapper.AuthPermissionDao;
import com.cccs7.auth.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthPermission)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-02 22:36:20
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionDao authPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthPermission queryById(Long id) {
        return this.authPermissionDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(AuthPermission authPermission) {
        return this.authPermissionDao.insert(authPermission);
    }

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int update(AuthPermission authPermission) {
        return this.authPermissionDao.update(authPermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authPermissionDao.deleteById(id) > 0;
    }


    @Override
    public List<AuthPermission> queryByPermissionIdList(List<Long> permissionIdList) {
        return this.authPermissionDao.queryByPermissionIdList(permissionIdList);
    }
}
