package com.cccs7.circle.service;

import com.cccs7.circle.bo.ShareMomentBO;

import java.util.List;

/**
 * 动态域服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
public interface MomentDomainService {
    /**
     * 查询动态列表通过用户ID
     *
     * @param shareMomentBO 分享时刻bo
     * @return {@link List }<{@link ShareMomentBO }>
     */
    List<ShareMomentBO> getMomentListByUserId(ShareMomentBO shareMomentBO);

    /**
     * 搜索动态
     *
     * @param momentBO 时刻波
     * @return {@link List }<{@link ShareMomentBO }>
     */
    List<ShareMomentBO> searchMoment(ShareMomentBO momentBO);

    /**
     * 新增
     *
     * @param shareMomentBO 分享时刻bo
     * @return boolean
     */
    boolean add(ShareMomentBO shareMomentBO);

    /**
     * 更新
     *
     * @param momentBO 时刻波
     * @return boolean
     */
    boolean update(ShareMomentBO momentBO);
}
