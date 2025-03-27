package com.cccs7.practice.infra.basic.service;

import com.cccs7.practice.infra.basic.entity.PracticeSet;

/**
 * 套题信息表(PracticeSet)表服务接口
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
public interface PracticeSetService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PracticeSet queryById(Long id);


    /**
     * 新增数据
     *
     * @param practiceSet 实例对象
     * @return 实例对象
     */
    PracticeSet insert(PracticeSet practiceSet);

    /**
     * 修改数据
     *
     * @param practiceSet 实例对象
     * @return 实例对象
     */
    PracticeSet update(PracticeSet practiceSet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
