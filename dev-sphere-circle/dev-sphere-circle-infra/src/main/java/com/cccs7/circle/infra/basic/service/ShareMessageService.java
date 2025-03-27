package com.cccs7.circle.infra.basic.service;

import com.cccs7.circle.infra.basic.entity.ShareMessage;

/**
 * 消息表(ShareMessage)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public interface ShareMessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareMessage queryById(Integer id);


    /**
     * 新增数据
     *
     * @param shareMessage 实例对象
     * @return 实例对象
     */
    ShareMessage insert(ShareMessage shareMessage);

    /**
     * 修改数据
     *
     * @param shareMessage 实例对象
     * @return 实例对象
     */
    ShareMessage update(ShareMessage shareMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
