package com.cccs7.circle.application.controller;

import com.cccs7.circle.application.convert.CircleActionConverter;
import com.cccs7.circle.application.convert.CircleDTOConverter;
import com.cccs7.circle.application.dto.CircleActionDTO;
import com.cccs7.circle.application.dto.ShareCircleDTO;
import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.bo.ShareCircleMemberBO;
import com.cccs7.circle.common.entity.Result;
import com.cccs7.circle.service.CircleDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/circle/")
public class CircleController {


    @Resource
    private CircleDomainService circleDomainService;


    /**
     * 新增圈子
     *
     * @param shareCircleDTO 分享圈子d
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody ShareCircleDTO shareCircleDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.add.dto:{}", shareCircleDTO);
        }

        Preconditions.checkNotNull(shareCircleDTO.getCircleName(), "圈子名称不能为空");
        Preconditions.checkNotNull(shareCircleDTO.getCircleName(), "圈子简介不能为空");

        ShareCircleBO circleBO = CircleDTOConverter.INSTANCE.dto2bo(shareCircleDTO);
        boolean add = circleDomainService.add(circleBO);
        return Result.ok(add);
    }

    /**
     * 更新
     *
     * @param shareCircleDTO 分享圈子d
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody ShareCircleDTO shareCircleDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.update.dto:{}", shareCircleDTO);
        }

        Preconditions.checkNotNull(shareCircleDTO.getId(), "圈子ID不能为空");

        ShareCircleBO circleBO = CircleDTOConverter.INSTANCE.dto2bo(shareCircleDTO);
        boolean update = circleDomainService.update(circleBO);
        return Result.ok(update);
    }

    /**
     * 订阅圈子
     *
     * @param circleActionDTO 循环作用dto
     * @return {@link Result }<{@link String }>
     */
    @PostMapping("subscribe")
    public Result<String> subscribe(@RequestBody CircleActionDTO circleActionDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.subscribe.dto:{}", circleActionDTO);
        }

        Preconditions.checkNotNull(circleActionDTO.getCircleId(), "圈子ID不能为空");
        Preconditions.checkNotNull(circleActionDTO.getUserId(), "用户ID不能为空");

        ShareCircleMemberBO circleMemberBO = CircleActionConverter.INSTANCE.action2MemberBO(circleActionDTO);
        boolean update = circleDomainService.subscribe(circleMemberBO);
        return Result.ok(update);
    }

    /**
     * 通过用户ID查询订阅列表
     *
     * @param circleActionDTO 循环作用dto
     * @return {@link Result }<{@link List }<{@link ShareCircleDTO }>>
     */
    @PostMapping("getSubscribeListByUserId")
    public Result<List<ShareCircleDTO>> getSubscribeListByUserId(@RequestBody CircleActionDTO circleActionDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.getSubscribeListByUserId.dto:{}", circleActionDTO);
        }

        Preconditions.checkNotNull(circleActionDTO.getUserId(), "用户ID不能为空");

        ShareCircleMemberBO circleMemberBO = CircleActionConverter.INSTANCE.action2MemberBO(circleActionDTO);
        List<ShareCircleBO> circleBOList = circleDomainService.getSubscribeListByUserId(circleMemberBO);
        List<ShareCircleDTO> dtoList = CircleDTOConverter.INSTANCE.bos2dtos(circleBOList);
        return Result.ok(dtoList);
    }

    /**
     * 按圈名搜索圈子
     *
     * @param circleActionDTO 循环作用dto
     * @return {@link Result }<{@link List }<{@link ShareCircleDTO }>>
     */
    @PostMapping("searchCircleBy")
    public Result<List<ShareCircleDTO>> searchCircleByCircleName(@RequestBody CircleActionDTO circleActionDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.searchCircleByCircleName.dto:{}", circleActionDTO);
        }

        Preconditions.checkNotNull(circleActionDTO.getCircleName(), "搜索关键词不能为空");

        ShareCircleMemberBO circleMemberBO = CircleActionConverter.INSTANCE.action2MemberBO(circleActionDTO);
        List<ShareCircleBO> circleBOList = circleDomainService.searchCircleByCircleName(circleMemberBO);
        List<ShareCircleDTO> dtoList = CircleDTOConverter.INSTANCE.bos2dtos(circleBOList);
        return Result.ok(dtoList);
    }


}
