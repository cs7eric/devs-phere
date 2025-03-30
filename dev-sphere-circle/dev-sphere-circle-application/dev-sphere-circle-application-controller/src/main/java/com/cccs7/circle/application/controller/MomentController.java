package com.cccs7.circle.application.controller;

import com.cccs7.circle.application.convert.MomentDTOConverter;
import com.cccs7.circle.application.dto.ShareMomentDTO;
import com.cccs7.circle.bo.ShareMomentBO;
import com.cccs7.circle.common.entity.Result;
import com.cccs7.circle.service.MomentDomainService;
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
@RequestMapping("/circle/moment")
public class MomentController {


    @Resource
    private MomentDomainService momentDomainService;


    /**
     * 新增动态
     *
     * @param shareMomentDTO 动态
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("add")
    public Result<Boolean> add(@RequestBody ShareMomentDTO shareMomentDTO) {


        if (log.isInfoEnabled()) {
            log.info("CircleController.add.dto:{}", shareMomentDTO);
        }

        Preconditions.checkNotNull(shareMomentDTO.getContent(), "动态内容不能为空");
        Preconditions.checkNotNull(shareMomentDTO.getMomentTitle(), "动态名称不能为空");
        Preconditions.checkNotNull(shareMomentDTO.getAuthorId(), "作者ID不能为空");

        ShareMomentBO shareMomentBO = MomentDTOConverter.INSTANCE.dto2bo(shareMomentDTO);

        boolean add = momentDomainService.add(shareMomentBO);
        return Result.ok(add);
    }

    /**
     * 更新
     *
     * @param shareMomentDTO 动态
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("update")
    public Result<Boolean> update(@RequestBody ShareMomentDTO shareMomentDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.update.dto:{}", shareMomentDTO);
        }

        Preconditions.checkNotNull(shareMomentDTO.getId(), "动态ID不能为空");

        ShareMomentBO momentBO = MomentDTOConverter.INSTANCE.dto2bo(shareMomentDTO);

        boolean update = momentDomainService.update(momentBO);
        return Result.ok(update);
    }


    /**
     * 通过用户ID查询动态列表
     *
     * @param shareMomentDTO 动态DTO
     * @return {@link Result }<{@link List }<{@link ShareMomentDTO }>>
     */
    @PostMapping("getSubscribeListByUserId")
    public Result<List<ShareMomentDTO>> getMomentListByUserId(@RequestBody ShareMomentDTO shareMomentDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.getSubscribeListByUserId.dto:{}", shareMomentDTO);
        }

        Preconditions.checkNotNull(shareMomentDTO.getAuthorId(), "作者ID不能为空");


        ShareMomentBO shareMomentBO = MomentDTOConverter.INSTANCE.dto2bo(shareMomentDTO);
        List<ShareMomentBO> shareMomentBOList = momentDomainService.getMomentListByUserId(shareMomentBO);
        List<ShareMomentDTO> dtoList = MomentDTOConverter.INSTANCE.bos2dtos(shareMomentBOList);
        return Result.ok(dtoList);
    }

    /**
     * 搜索动态
     *
     * @param shareMomentDTO 动态DTO
     * @return {@link Result }<{@link List }<{@link ShareMomentDTO }>>
     */
    @PostMapping("searchCircleBy")
    public Result<List<ShareMomentDTO>> searchMoment(@RequestBody ShareMomentDTO shareMomentDTO) {

        if (log.isInfoEnabled()) {
            log.info("CircleController.searchMoment.dto:{}", shareMomentDTO);
        }

        Preconditions.checkNotNull(shareMomentDTO.getKeyword(), "搜索关键词不能为空");

        ShareMomentBO momentBO = MomentDTOConverter.INSTANCE.dto2bo(shareMomentDTO);
        List<ShareMomentBO> boList = momentDomainService.searchMoment(momentBO);
        List<ShareMomentDTO> dtoList = MomentDTOConverter.INSTANCE.bos2dtos(boList);

        return Result.ok(dtoList);
    }


}
