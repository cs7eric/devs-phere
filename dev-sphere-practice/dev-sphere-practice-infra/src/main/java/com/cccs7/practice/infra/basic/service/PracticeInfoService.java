package com.cccs7.practice.infra.basic.service;

import com.cccs7.practice.infra.basic.entity.PracticeInfo;

/**
 * 练习表(PracticeInfo)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
public interface PracticeInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PracticeInfo queryById(Long id);


    /**
     * 新增数据
     *
     * @param practiceInfo 实例对象
     * @return 实例对象
     */
    PracticeInfo insert(PracticeInfo practiceInfo);

    /**
     * 修改数据
     *
     * @param practiceInfo 实例对象
     * @return 实例对象
     */
    PracticeInfo update(PracticeInfo practiceInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
