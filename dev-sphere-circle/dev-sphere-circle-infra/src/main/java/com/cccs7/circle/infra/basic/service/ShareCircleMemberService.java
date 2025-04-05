package com.cccs7.circle.infra.basic.service;

import com.cccs7.circle.infra.basic.entity.ShareCircle;
import com.cccs7.circle.infra.basic.entity.ShareCircleMember;

import java.util.List;

/**
 * 圈子成员信息(ShareCircleMember)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:09:18
 */
public interface ShareCircleMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareCircleMember queryById(Long id);

    /**
     * 新增数据
     *
     * @param shareCircleMember 实例对象
     * @return 实例对象
     */
    ShareCircleMember insert(ShareCircleMember shareCircleMember);

    /**
     * 修改数据
     *
     * @param shareCircleMember 实例对象
     * @return 实例对象
     */
    ShareCircleMember update(ShareCircleMember shareCircleMember);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询订阅列表通过用户
     *
     * @param userName 用户名
     * @return {@link List }<{@link ShareCircle }>
     */
    List<ShareCircleMember> getSubscribeListByUser(String userName);
}
