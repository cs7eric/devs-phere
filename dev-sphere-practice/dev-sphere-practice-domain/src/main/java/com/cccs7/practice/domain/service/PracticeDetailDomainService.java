package com.cccs7.practice.domain.service;


import com.cccs7.practice.domain.entity.PracticeDetailBO;

/**
 * 练习详情表 领域service
 *
 * @author cccs7
 * @since 2025-05-14 23:43:15
 */
public interface PracticeDetailDomainService {

    /**
     * 添加 练习详情表 信息
     */
    Boolean add(PracticeDetailBO practiceDetailBO);

    /**
     * 更新 练习详情表 信息
     */
    Boolean update(PracticeDetailBO practiceDetailBO);

    /**
     * 删除 练习详情表 信息
     */
    Boolean delete(PracticeDetailBO practiceDetailBO);

}
