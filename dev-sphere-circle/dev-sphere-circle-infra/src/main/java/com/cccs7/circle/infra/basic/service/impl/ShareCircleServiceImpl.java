package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.mapper.ShareCircleDao;
import com.cccs7.circle.infra.basic.entity.ShareCircle;
import com.cccs7.circle.infra.basic.service.ShareCircleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 圈子信息(ShareCircle)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:18:47
 */
@Service("shareCircleService")
public class ShareCircleServiceImpl implements ShareCircleService {
    @Resource
    private ShareCircleDao shareCircleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareCircle queryById(Long id) {
        return this.shareCircleDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param shareCircle 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCircle insert(ShareCircle shareCircle) {
        this.shareCircleDao.insert(shareCircle);
        return shareCircle;
    }

    /**
     * 修改数据
     *
     * @param shareCircle 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCircle update(ShareCircle shareCircle) {
        this.shareCircleDao.update(shareCircle);
        return this.queryById(shareCircle.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareCircleDao.deleteById(id) > 0;
    }

    @Override
    public List<ShareCircle> queryByCondition(ShareCircle circle) {
        return this.shareCircleDao.queryByCondition(circle);
    }
}
