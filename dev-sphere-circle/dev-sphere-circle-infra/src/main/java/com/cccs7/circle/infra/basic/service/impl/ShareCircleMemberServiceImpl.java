package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.dao.ShareCircleMemberDao;
import com.cccs7.circle.infra.basic.entity.ShareCircleMember;
import com.cccs7.circle.infra.basic.service.ShareCircleMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 圈子成员信息(ShareCircleMember)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:09:18
 */
@Service("shareCircleMemberService")
public class ShareCircleMemberServiceImpl implements ShareCircleMemberService {
    @Resource
    private ShareCircleMemberDao shareCircleMemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareCircleMember queryById(Long id) {
        return this.shareCircleMemberDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param shareCircleMember 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCircleMember insert(ShareCircleMember shareCircleMember) {
        this.shareCircleMemberDao.insert(shareCircleMember);
        return shareCircleMember;
    }

    /**
     * 修改数据
     *
     * @param shareCircleMember 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCircleMember update(ShareCircleMember shareCircleMember) {
        this.shareCircleMemberDao.update(shareCircleMember);
        return this.queryById(shareCircleMember.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareCircleMemberDao.deleteById(id) > 0;
    }
}
