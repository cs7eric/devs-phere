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


    List<ShareCircleBO> searchCircleByCircleName(ShareCircleMemberBO circleMemberBO);

    List<ShareCircleBO> getSubscribeListByUserId(ShareCircleMemberBO circleMemberBO);

    boolean subscribe(ShareCircleMemberBO circleMemberBO);

    boolean update(ShareCircleBO circleBO);

    boolean add(ShareCircleBO circleBO);
}
