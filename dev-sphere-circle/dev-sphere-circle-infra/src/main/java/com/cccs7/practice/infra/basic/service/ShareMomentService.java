package com.cccs7.practice.infra.basic.service;

import com.cccs7.practice.infra.basic.entity.ShareMoment;

/**
 * 动态信息(ShareMoment)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public interface ShareMomentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareMoment queryById(Long id);


    /**
     * 新增数据
     *
     * @param shareMoment 实例对象
     * @return 实例对象
     */
    ShareMoment insert(ShareMoment shareMoment);

    /**
     * 修改数据
     *
     * @param shareMoment 实例对象
     * @return 实例对象
     */
    ShareMoment update(ShareMoment shareMoment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
