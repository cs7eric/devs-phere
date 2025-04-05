package com.cccs7.circle.application.controller;

import com.cccs7.circle.application.convert.InteractionDTOConverter;
import com.cccs7.circle.application.dto.InteractionDTO;
import com.cccs7.circle.bo.InteractionBO;
import com.cccs7.circle.common.entity.Result;
import com.cccs7.circle.service.InteractionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 交互controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/04/03
 */
@Slf4j
@RestController
@RequestMapping("/share/interactions/")
public class InteractionController {


    @Resource
    private InteractionDomainService interactionDomainService;

    @PostMapping("/like")
    public Result<String> like(@RequestBody InteractionDTO interactionDTO) {

        if (log.isInfoEnabled()) {
            log.info("InteractionController.like.dto:{}", interactionDTO);
        }
        Preconditions.checkNotNull(interactionDTO.getUserName(), "用户名不能为空");
        Preconditions.checkNotNull(interactionDTO.getTargetId(), "目标ID不能为空");
        InteractionBO interactionBO = InteractionDTOConverter.INSTANCE.dto2bo(interactionDTO);
        interactionDomainService.like(interactionBO);
        // 处理点赞逻辑（可以是文章、动态等）
        return Result.ok();
    }
    @PostMapping("/collect")
    public Result<String> collect(@RequestBody InteractionDTO interactionDTO) {
        if (log.isInfoEnabled()) {
            log.info("InteractionController.like.dto:{}", interactionDTO);
        }
        Preconditions.checkNotNull(interactionDTO.getUserName(), "用户名不能为空");
        Preconditions.checkNotNull(interactionDTO.getTargetId(), "目标ID不能为空");
        InteractionBO interactionBO = InteractionDTOConverter.INSTANCE.dto2bo(interactionDTO);
        interactionDomainService.collect(interactionBO);
        // 处理点赞逻辑（可以是文章、动态等）
        return Result.ok();
    }

    @PostMapping("/join")
    public Result<String> join(@RequestBody InteractionDTO interactionDTO) {
        if (log.isInfoEnabled()) {
            log.info("InteractionController.like.dto:{}", interactionDTO);
        }
        Preconditions.checkNotNull(interactionDTO.getUserName(), "用户名不能为空");
        Preconditions.checkNotNull(interactionDTO.getTargetId(), "目标ID不能为空");
        InteractionBO interactionBO = InteractionDTOConverter.INSTANCE.dto2bo(interactionDTO);
        interactionDomainService.join(interactionBO);
        // 处理点赞逻辑（可以是文章、动态等）
        return Result.ok();
    }

    @PostMapping("/comment")
    public Result<String> comment(@RequestBody InteractionDTO interactionDTO) {
        if (log.isInfoEnabled()) {
            log.info("InteractionController.like.dto:{}", interactionDTO);
        }
        Preconditions.checkNotNull(interactionDTO.getUserName(), "用户名不能为空");
        Preconditions.checkNotNull(interactionDTO.getTargetId(), "目标ID不能为空");
        InteractionBO interactionBO = InteractionDTOConverter.INSTANCE.dto2bo(interactionDTO);
        interactionDomainService.comment(interactionBO);
        // 处理点赞逻辑（可以是文章、动态等）
        return Result.ok();
    }


}
