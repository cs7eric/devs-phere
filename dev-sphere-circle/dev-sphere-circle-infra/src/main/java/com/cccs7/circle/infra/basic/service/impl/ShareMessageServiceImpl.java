package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.dao.ShareMessageDao;
import com.cccs7.circle.infra.basic.entity.ShareMessage;
import com.cccs7.circle.infra.basic.service.ShareMessageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 消息表(ShareMessage)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
@Service("shareMessageService")
public class ShareMessageServiceImpl implements ShareMessageService {
    @Resource
    private ShareMessageDao shareMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareMessage queryById(Integer id) {
        return this.shareMessageDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param shareMessage 实例对象
     * @return 实例对象
     */
    @Override
    public ShareMessage insert(ShareMessage shareMessage) {
        this.shareMessageDao.insert(shareMessage);
        return shareMessage;
    }

    /**
     * 修改数据
     *
     * @param shareMessage 实例对象
     * @return 实例对象
     */
    @Override
    public ShareMessage update(ShareMessage shareMessage) {
        this.shareMessageDao.update(shareMessage);
        return this.queryById(shareMessage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shareMessageDao.deleteById(id) > 0;
    }
}
