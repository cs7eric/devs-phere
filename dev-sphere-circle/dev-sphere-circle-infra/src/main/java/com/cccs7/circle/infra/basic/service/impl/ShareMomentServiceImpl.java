package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.entity.ShareMoment;
import com.cccs7.circle.infra.basic.dao.ShareMomentDao;
import com.cccs7.circle.infra.basic.service.ShareMomentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 动态信息(ShareMoment)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:36:11
 */
@Service("shareMomentService")
public class ShareMomentServiceImpl implements ShareMomentService {
    @Resource
    private ShareMomentDao shareMomentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareMoment queryById(Long id) {
        return this.shareMomentDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param shareMoment 实例对象
     * @return 实例对象
     */
    @Override
    public ShareMoment insert(ShareMoment shareMoment) {
        this.shareMomentDao.insert(shareMoment);
        return shareMoment;
    }

    /**
     * 修改数据
     *
     * @param shareMoment 实例对象
     * @return 实例对象
     */
    @Override
    public ShareMoment update(ShareMoment shareMoment) {
        this.shareMomentDao.update(shareMoment);
        return this.queryById(shareMoment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareMomentDao.deleteById(id) > 0;
    }
}
