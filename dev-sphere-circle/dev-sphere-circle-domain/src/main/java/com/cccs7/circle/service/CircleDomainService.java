package com.cccs7.circle.service;

import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.bo.ShareCircleMemberBO;

import java.util.List;

/**
 * 圈子域服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
public interface CircleDomainService {


    /**
     * 按圈名搜索圈
     *
     * @param circleMemberBO 圈子成员bo
     * @return {@link List }<{@link ShareCircleBO }>
     */
    List<ShareCircleBO> searchCircleByCircleName(ShareCircleMemberBO circleMemberBO);

    /**
     * 查询订阅列表通过用户ID
     *
     * @param circleMemberBO 圈子成员bo
     * @return {@link List }<{@link ShareCircleBO }>
     */
    List<ShareCircleBO> getSubscribeListByUserId(ShareCircleMemberBO circleMemberBO);

    /**
     * 订阅
     *
     * @param circleMemberBO 圈子成员bo
     * @return boolean
     */
    boolean subscribe(ShareCircleMemberBO circleMemberBO);

    /**
     * 更新
     *
     * @param circleBO 圆博
     * @return boolean
     */
    boolean update(ShareCircleBO circleBO);

    /**
     * 新增
     *
     * @param circleBO 圆博
     * @return boolean
     */
    boolean add(ShareCircleBO circleBO);

    /**
     * 查询圈子列表通过类别
     *
     * @param circleBO 圆博
     * @return {@link List }<{@link ShareCircleBO }>
     */
    List<ShareCircleBO> getCircleListByCategory(ShareCircleBO circleBO);
}
