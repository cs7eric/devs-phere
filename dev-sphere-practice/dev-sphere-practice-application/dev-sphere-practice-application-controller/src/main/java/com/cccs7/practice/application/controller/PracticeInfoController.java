package com.cccs7.practice.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.cccs7.practice.application.convert.PracticeInfoDTOConverter;
import com.cccs7.practice.application.dto.PracticeInfoDTO;
import com.cccs7.practice.common.entity.Result;
import com.cccs7.practice.domain.entity.PracticeInfoBO;
import com.cccs7.practice.domain.service.PracticeInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 练习表 controller
 *
 * @author cccs7
 * @since 2025-05-14 23:41:32
 */
@RestController
@RequestMapping("/practice/")
@Slf4j
public class PracticeInfoController {

    @Resource
    private PracticeInfoDomainService practiceInfoDomainService;

    /**
     * 新增练习表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody PracticeInfoDTO practiceInfoDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeInfoController.add.dto:{}", JSON.toJSONString(practiceInfoDTO));
            }
            Preconditions.checkNotNull(practiceInfoDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCompleteStatus(), "是否完成 1完成 0未完成不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getTimeUse(), "用时不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSubmitTime(), "交卷时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCorrectRate(), "正确率不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeInfoBO PracticeInfoBO = PracticeInfoDTOConverter.INSTANCE.convertDTOToBO(practiceInfoDTO);
            return Result.ok(practiceInfoDomainService.add(PracticeInfoBO));
        } catch (Exception e) {
            log.error("PracticeInfoController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增练习表失败");
        }

    }

    /**
     * 修改练习表
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody PracticeInfoDTO practiceInfoDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeInfoController.update.dto:{}", JSON.toJSONString(practiceInfoDTO));
            }
            Preconditions.checkNotNull(practiceInfoDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCompleteStatus(), "是否完成 1完成 0未完成不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getTimeUse(), "用时不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSubmitTime(), "交卷时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCorrectRate(), "正确率不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeInfoBO practiceInfoBO = PracticeInfoDTOConverter.INSTANCE.convertDTOToBO(practiceInfoDTO);
            return Result.ok(practiceInfoDomainService.update(practiceInfoBO));
        } catch (Exception e) {
            log.error("PracticeInfoController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新练习表信息失败");
        }

    }

    /**
     * 删除练习表
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody PracticeInfoDTO practiceInfoDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeInfoController.delete.dto:{}", JSON.toJSONString(practiceInfoDTO));
            }
            Preconditions.checkNotNull(practiceInfoDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSetId(), "套题id不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCompleteStatus(), "是否完成 1完成 0未完成不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getTimeUse(), "用时不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getSubmitTime(), "交卷时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCorrectRate(), "正确率不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceInfoDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeInfoBO practiceInfoBO = PracticeInfoDTOConverter.INSTANCE.convertDTOToBO(practiceInfoDTO);
            return Result.ok(practiceInfoDomainService.delete(practiceInfoBO));
        } catch (Exception e) {
            log.error("PracticeInfoController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除练习表信息失败");
        }

    }

}
