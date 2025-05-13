package com.cccs7.auth.basic.service.impl;

import com.cccs7.auth.basic.entity.AuthUser;
import com.cccs7.auth.basic.mapper.AuthUserDao;
import com.cccs7.auth.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(AuthUser)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-01 19:37:26
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserDao authUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthUser authUser) {
        return this.authUserDao.insert(authUser);
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserDao.deleteById(id) > 0;
    }

    /**
     * 按用户名更新
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    @Override
    public Integer updateByUserName(AuthUser authUser) {
        return this.authUserDao.updateByUserName(authUser);
    }


    /**
     * 删除
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    @Override
    public Integer delete(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    /**
     * 用户启用/禁用
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    @Override
    public Integer changeStatus(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    /**
     * 按条件查询
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    @Override
    public List<AuthUser> queryByCondition(AuthUser authUser) {
        return this.authUserDao.queryByCondition(authUser);
    }

    /**
     * 查询所有
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    @Override
    public List<AuthUser> queryAll(AuthUser authUser) {
        return this.authUserDao.queryAll(authUser);
    }

    /**
     * 通过昵称查找用户
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    @Override
    public List<AuthUser> findUserByNickName(AuthUser authUser) {
        return this.authUserDao.findUserByNickName(authUser);
    }
}
