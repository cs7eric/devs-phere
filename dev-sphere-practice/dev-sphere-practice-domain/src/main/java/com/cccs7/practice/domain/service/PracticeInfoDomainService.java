package com.cccs7.practice.domain.service;


import com.cccs7.practice.domain.entity.PracticeInfoBO;

/**
 * 练习表 领域service
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
public interface PracticeInfoDomainService {

    /**
     * 添加 练习表 信息
     */
    Boolean add(PracticeInfoBO practiceInfoBO);

    /**
     * 更新 练习表 信息
     */
    Boolean update(PracticeInfoBO practiceInfoBO);

    /**
     * 删除 练习表 信息
     */
    Boolean delete(PracticeInfoBO practiceInfoBO);

}
