package com.cccs7.practice.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.cccs7.practice.application.convert.PracticeSetDetailDTOConverter;
import com.cccs7.practice.application.dto.PracticeSetDetailDTO;
import com.cccs7.practice.common.entity.Result;
import com.cccs7.practice.domain.entity.PracticeSetDetailBO;
import com.cccs7.practice.domain.service.PracticeSetDetailDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 套题内容表 controller
 *
 * @author cccs7
 * @since 2025-05-14 23:44:15
 */
@RestController
@RequestMapping("/practice/setDetail/")
@Slf4j
public class PracticeSetDetailController {

    @Resource
    private PracticeSetDetailDomainService practiceSetDetailDomainService;

    /**
     * 新增套题内容表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody PracticeSetDetailDTO practiceSetDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetDetailController.add.dto:{}", JSON.toJSONString(practiceSetDetailDTO));
            }
            Preconditions.checkNotNull(practiceSetDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetDetailBO PracticeSetDetailBO = PracticeSetDetailDTOConverter.INSTANCE.convertDTOToBO(practiceSetDetailDTO);
            return Result.ok(practiceSetDetailDomainService.add(PracticeSetDetailBO));
        } catch (Exception e) {
            log.error("PracticeSetDetailController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增套题内容表失败");
        }

    }

    /**
     * 修改套题内容表
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody PracticeSetDetailDTO practiceSetDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetDetailController.update.dto:{}", JSON.toJSONString(practiceSetDetailDTO));
            }
            Preconditions.checkNotNull(practiceSetDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetDetailBO practiceSetDetailBO = PracticeSetDetailDTOConverter.INSTANCE.convertDTOToBO(practiceSetDetailDTO);
            return Result.ok(practiceSetDetailDomainService.update(practiceSetDetailBO));
        } catch (Exception e) {
            log.error("PracticeSetDetailController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新套题内容表信息失败");
        }

    }

    /**
     * 删除套题内容表
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody PracticeSetDetailDTO practiceSetDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetDetailController.delete.dto:{}", JSON.toJSONString(practiceSetDetailDTO));
            }
            Preconditions.checkNotNull(practiceSetDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetDetailBO practiceSetDetailBO = PracticeSetDetailDTOConverter.INSTANCE.convertDTOToBO(practiceSetDetailDTO);
            return Result.ok(practiceSetDetailDomainService.delete(practiceSetDetailBO));
        } catch (Exception e) {
            log.error("PracticeSetDetailController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除套题内容表信息失败");
        }

    }

}
