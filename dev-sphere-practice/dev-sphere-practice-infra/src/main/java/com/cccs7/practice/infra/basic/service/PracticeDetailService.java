package com.cccs7.practice.infra.basic.service;

import com.cccs7.practice.infra.basic.entity.PracticeDetail;

/**
 * 练习详情表(PracticeDetail)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:02
 */
public interface PracticeDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PracticeDetail queryById(Long id);


    /**
     * 新增数据
     *
     * @param practiceDetail 实例对象
     * @return 实例对象
     */
    PracticeDetail insert(PracticeDetail practiceDetail);

    /**
     * 修改数据
     *
     * @param practiceDetail 实例对象
     * @return 实例对象
     */
    PracticeDetail update(PracticeDetail practiceDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
