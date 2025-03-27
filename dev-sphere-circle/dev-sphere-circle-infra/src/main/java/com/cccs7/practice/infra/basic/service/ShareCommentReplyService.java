package com.cccs7.practice.infra.basic.service;

import com.cccs7.practice.infra.basic.entity.ShareCommentReply;

/**
 * 评论及回复信息(ShareCommentReply)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public interface ShareCommentReplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareCommentReply queryById(Long id);


    /**
     * 新增数据
     *
     * @param shareCommentReply 实例对象
     * @return 实例对象
     */
    ShareCommentReply insert(ShareCommentReply shareCommentReply);

    /**
     * 修改数据
     *
     * @param shareCommentReply 实例对象
     * @return 实例对象
     */
    ShareCommentReply update(ShareCommentReply shareCommentReply);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
