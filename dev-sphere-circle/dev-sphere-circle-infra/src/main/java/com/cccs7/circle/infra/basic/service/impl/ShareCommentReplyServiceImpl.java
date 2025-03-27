package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.entity.ShareCommentReply;
import com.cccs7.circle.infra.basic.dao.ShareCommentReplyDao;
import com.cccs7.circle.infra.basic.service.ShareCommentReplyService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 评论及回复信息(ShareCommentReply)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
@Service("shareCommentReplyService")
public class ShareCommentReplyServiceImpl implements ShareCommentReplyService {
    @Resource
    private ShareCommentReplyDao shareCommentReplyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareCommentReply queryById(Long id) {
        return this.shareCommentReplyDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param shareCommentReply 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCommentReply insert(ShareCommentReply shareCommentReply) {
        this.shareCommentReplyDao.insert(shareCommentReply);
        return shareCommentReply;
    }

    /**
     * 修改数据
     *
     * @param shareCommentReply 实例对象
     * @return 实例对象
     */
    @Override
    public ShareCommentReply update(ShareCommentReply shareCommentReply) {
        this.shareCommentReplyDao.update(shareCommentReply);
        return this.queryById(shareCommentReply.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareCommentReplyDao.deleteById(id) > 0;
    }
}
