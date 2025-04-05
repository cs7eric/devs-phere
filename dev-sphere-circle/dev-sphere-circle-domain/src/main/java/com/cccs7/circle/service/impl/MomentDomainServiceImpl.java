package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareMomentBO;
import com.cccs7.circle.convert.MomentBOConverter;
import com.cccs7.circle.infra.basic.entity.ShareMoment;
import com.cccs7.circle.infra.basic.service.ShareMomentService;
import com.cccs7.circle.service.MomentDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动态域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
@Slf4j
@Service
public class MomentDomainServiceImpl
        implements MomentDomainService {

    @Resource
    private ShareMomentService momentService;

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
        if (log.isInfoEnabled()) {
            log.info("MomentDomainServiceImpl.add.bo:{}", shareMomentBO);
        }
        try {
            ShareMoment shareMoment = MomentBOConverter.INSTANCE.bo2po(shareMomentBO);
            shareMoment.setIsDeleted(0);
            shareMoment.setLikeCount(0);
            shareMoment.setReplyCount(0);
            shareMoment.setCollectCount(0);
            ShareMoment insert = momentService.insert(shareMoment);
        } catch (Exception e) {
            log.error("MomentDomainServiceImpl.add.bo.error:{}", e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ShareMomentBO momentBO) {
        return false;
    }
}
