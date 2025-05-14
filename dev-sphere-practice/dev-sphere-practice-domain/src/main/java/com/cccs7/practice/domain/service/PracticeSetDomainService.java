package com.cccs7.practice.domain.service;


import com.cccs7.practice.domain.entity.PracticeSetBO;

/**
 * 套题信息表 领域service
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
public interface PracticeSetDomainService {

    /**
     * 添加 套题信息表 信息
     */
    Boolean add(PracticeSetBO practiceSetBO);

    /**
     * 更新 套题信息表 信息
     */
    Boolean update(PracticeSetBO practiceSetBO);

    /**
     * 删除 套题信息表 信息
     */
    Boolean delete(PracticeSetBO practiceSetBO);

}
