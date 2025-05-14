package com.cccs7.practice.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.cccs7.practice.application.convert.PracticeDetailDTOConverter;
import com.cccs7.practice.application.dto.PracticeDetailDTO;
import com.cccs7.practice.common.entity.Result;
import com.cccs7.practice.domain.entity.PracticeDetailBO;
import com.cccs7.practice.domain.service.PracticeDetailDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 练习详情表 controller
 *
 * @author cccs7
 * @since 2025-05-14 23:43:15
 */
@RestController
@RequestMapping("/practice/detail/")
@Slf4j
public class PracticeDetailController {

    @Resource
    private PracticeDetailDomainService practiceDetailDomainService;

    /**
     * 新增练习详情表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody PracticeDetailDTO practiceDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeDetailController.add.dto:{}", JSON.toJSONString(practiceDetailDTO));
            }
            Preconditions.checkNotNull(practiceDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getPracticeId(), "练题id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerStatus(), "回答状态不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerContent(), "回答内容不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeDetailBO PracticeDetailBO = PracticeDetailDTOConverter.INSTANCE.convertDTOToBO(practiceDetailDTO);
            return Result.ok(practiceDetailDomainService.add(PracticeDetailBO));
        } catch (Exception e) {
            log.error("PracticeDetailController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增练习详情表失败");
        }

    }

    /**
     * 修改练习详情表
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody PracticeDetailDTO practiceDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeDetailController.update.dto:{}", JSON.toJSONString(practiceDetailDTO));
            }
            Preconditions.checkNotNull(practiceDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getPracticeId(), "练题id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerStatus(), "回答状态不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerContent(), "回答内容不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeDetailBO practiceDetailBO = PracticeDetailDTOConverter.INSTANCE.convertDTOToBO(practiceDetailDTO);
            return Result.ok(practiceDetailDomainService.update(practiceDetailBO));
        } catch (Exception e) {
            log.error("PracticeDetailController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新练习详情表信息失败");
        }

    }

    /**
     * 删除练习详情表
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody PracticeDetailDTO practiceDetailDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeDetailController.delete.dto:{}", JSON.toJSONString(practiceDetailDTO));
            }
            Preconditions.checkNotNull(practiceDetailDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getPracticeId(), "练题id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectId(), "题目id不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerStatus(), "回答状态不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getAnswerContent(), "回答内容不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceDetailDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeDetailBO practiceDetailBO = PracticeDetailDTOConverter.INSTANCE.convertDTOToBO(practiceDetailDTO);
            return Result.ok(practiceDetailDomainService.delete(practiceDetailBO));
        } catch (Exception e) {
            log.error("PracticeDetailController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除练习详情表信息失败");
        }

    }

}
