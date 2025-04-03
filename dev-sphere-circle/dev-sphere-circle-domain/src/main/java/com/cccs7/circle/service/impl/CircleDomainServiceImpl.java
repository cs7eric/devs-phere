package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.bo.ShareCircleMemberBO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleDomainServiceImpl
        implements com.cccs7.circle.service.CircleDomainService {


    @Override
    public List<ShareCircleBO> searchCircleByCircleName(ShareCircleMemberBO circleMemberBO) {
        return null;
    }

    @Override
    public List<ShareCircleBO> getSubscribeListByUserId(ShareCircleMemberBO circleMemberBO) {
        return null;
    }

    @Override
    public boolean subscribe(ShareCircleMemberBO circleMemberBO) {
        return false;
    }

    @Override
    public boolean update(ShareCircleBO circleBO) {
        return false;
    }

    @Override
    public boolean add(ShareCircleBO circleBO) {
        return false;
    }
}
