package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareMomentBO;
import com.cccs7.circle.service.MomentDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 动态域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
@Service
public class MomentDomainServiceImpl
        implements MomentDomainService {


    @Override
    public List<ShareMomentBO> getMomentListByUserId(ShareMomentBO shareMomentBO) {
        return null;
    }

    @Override
    public List<ShareMomentBO> searchMoment(ShareMomentBO momentBO) {
        return null;
    }

    @Override
    public boolean add(ShareMomentBO shareMomentBO) {
        return false;
    }

    @Override
    public boolean update(ShareMomentBO momentBO) {
        return false;
    }
}
