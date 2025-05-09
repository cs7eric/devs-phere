package com.cccs7.circle.service.impl;

import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.bo.ShareCircleMemberBO;
import com.cccs7.circle.convert.CircleBOConverter;
import com.cccs7.circle.convert.CircleMemberBOConverter;
import com.cccs7.circle.infra.basic.entity.ShareCircle;
import com.cccs7.circle.infra.basic.entity.ShareCircleMember;
import com.cccs7.circle.infra.basic.service.ShareCircleMemberService;
import com.cccs7.circle.infra.basic.service.ShareCircleService;
import com.cccs7.circle.service.CircleDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 圈子域服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/04/05
 */
@Slf4j
@Service
public class CircleDomainServiceImpl
        implements CircleDomainService {

    @Resource
    private ShareCircleMemberService memberService;

    @Resource
    private ShareCircleService circleService;

    @Override
    public List<ShareCircleBO> searchCircleByCircleName(ShareCircleMemberBO circleMemberBO) {
        return null;
    }

    @Override
    public List<ShareCircleBO> getSubscribeListByUserId(ShareCircleMemberBO circleMemberBO) {
        List<ShareCircleMember> circleMemberList = memberService.getSubscribeListByUser(circleMemberBO.getUserName());
        List<Long> circleIdList = circleMemberList.stream()
                .map(ShareCircleMember::getCircleId)
                .collect(Collectors.toList());
        List<ShareCircle> circleList = circleIdList.stream().map(id ->
                circleService.queryById(id)
        ).collect(Collectors.toList());
        return CircleBOConverter.INSTANCE.pos2bos(circleList);
    }

    @Override
    @Transactional
    public boolean subscribe(ShareCircleMemberBO circleMemberBO) {

        if (log.isInfoEnabled()) {
            log.info("CircleDomainServiceImpl.subscribe.bo:{}", circleMemberBO);
        }
        ShareCircleMember member = CircleMemberBOConverter.INSTANCE.bo2po(circleMemberBO);
        ShareCircle circle = circleService.queryById(circleMemberBO.getCircleId());
        circle.setMemberCount(circle.getMemberCount() + 1);
        circleService.update(circle);
        memberService.insert(member);
        return true;
    }

    @Override
    public boolean update(ShareCircleBO circleBO) {
        return false;
    }

    @Override
    public boolean add(ShareCircleBO circleBO) {

        ShareCircle circle = CircleBOConverter.INSTANCE.bo2po(circleBO);
        circle.setIsDeleted(0);
        circle.setMemberCount(1);
        circle.setParentId(1L);
        ShareCircle insertedCircle = circleService.insert(circle);

        ShareCircleMember circleMember = new ShareCircleMember();
        circleMember.setCircleId(insertedCircle.getId());
        circleMember.setIsDeleted(0);
        circleMember.setUserName(circleBO.getUserName());
        memberService.insert(circleMember);

        return true;
    }

    @Override
    public List<ShareCircleBO> getCircleListByCategory(ShareCircleBO circleBO) {
        if (log.isInfoEnabled()) {
            log.info("CircleDomainServiceImpl.getCircleListByCategory.bo:{}", circleBO);
        }
        ShareCircle circle = CircleBOConverter.INSTANCE.bo2po(circleBO);
        circle.setIsDeleted(0);
        List<ShareCircle> circleList = circleService.queryByCondition(circle);
        List<ShareCircleBO> circleBOList = CircleBOConverter.INSTANCE.pos2bos(circleList);

        return circleBOList;
    }
}
