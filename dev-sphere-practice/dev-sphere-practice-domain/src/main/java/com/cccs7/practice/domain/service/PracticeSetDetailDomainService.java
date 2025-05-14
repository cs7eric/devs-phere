package com.cccs7.practice.domain.service;


import com.cccs7.practice.domain.entity.PracticeSetDetailBO;

/**
 * 套题内容表 领域service
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
public interface PracticeSetDetailDomainService {

    /**
     * 添加 套题内容表 信息
     */
    Boolean add(PracticeSetDetailBO practiceSetDetailBO);

    /**
     * 更新 套题内容表 信息
     */
    Boolean update(PracticeSetDetailBO practiceSetDetailBO);

    /**
     * 删除 套题内容表 信息
     */
    Boolean delete(PracticeSetDetailBO practiceSetDetailBO);

}
