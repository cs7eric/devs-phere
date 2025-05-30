package com.cccs7.auth.basic.mapper;

import com.cccs7.auth.basic.entity.AuthUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户信息表(AuthUser)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-01 19:37:26
 */
public interface AuthUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthUser queryById(Long id);



    /**
     * 统计总行数
     *
     * @param authUser 查询条件
     * @return 总行数
     */
    long count(AuthUser authUser);

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 影响行数
     */
    int insert(AuthUser authUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AuthUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthUser> entities);

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 影响行数
     */
    int update(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 按用户名更新
     *
     * @param authUser 身份验证用户
     * @return {@link Integer }
     */
    Integer updateByUserName(AuthUser authUser);

    /**
     * 按条件查询
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> queryByCondition(AuthUser authUser);

    /**
     * 查询所有
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> queryAll(AuthUser authUser);

    /**
     * 通过昵称查找用户
     *
     * @param authUser 身份验证用户
     * @return {@link List }<{@link AuthUser }>
     */
    List<AuthUser> findUserByNickName(AuthUser authUser);
}

