package com.cccs7.circle.infra.basic.service;

import com.cccs7.circle.infra.basic.entity.ShareCircleMember;

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

}
