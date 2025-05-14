package com.cccs7.practice.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.cccs7.practice.application.convert.PracticeSetDTOConverter;
import com.cccs7.practice.application.dto.PracticeSetDTO;
import com.cccs7.practice.common.entity.Result;
import com.cccs7.practice.domain.entity.PracticeSetBO;
import com.cccs7.practice.domain.service.PracticeSetDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 套题信息表 controller
 *
 * @author cccs7
 * @since 2025-05-14 23:43:45
 */
@RestController
@RequestMapping("/practice/set/")
@Slf4j
public class PracticeSetController {

    @Resource
    private PracticeSetDomainService practiceSetDomainService;

    /**
     * 新增套题信息表
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody PracticeSetDTO practiceSetDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetController.add.dto:{}", JSON.toJSONString(practiceSetDTO));
            }
            Preconditions.checkNotNull(practiceSetDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetName(), "套题名称不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetType(), "套题类型 1实时生成 2预设套题不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetHeat(), "热度不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetDesc(), "套题描述不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getPrimaryCategoryId(), "大类id不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetBO PracticeSetBO = PracticeSetDTOConverter.INSTANCE.convertDTOToBO(practiceSetDTO);
            return Result.ok(practiceSetDomainService.add(PracticeSetBO));
        } catch (Exception e) {
            log.error("PracticeSetController.register.error:{}", e.getMessage(), e);
            return Result.fail("新增套题信息表失败");
        }

    }

    /**
     * 修改套题信息表
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody PracticeSetDTO practiceSetDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetController.update.dto:{}", JSON.toJSONString(practiceSetDTO));
            }
            Preconditions.checkNotNull(practiceSetDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetName(), "套题名称不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetType(), "套题类型 1实时生成 2预设套题不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetHeat(), "热度不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetDesc(), "套题描述不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getPrimaryCategoryId(), "大类id不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetBO practiceSetBO = PracticeSetDTOConverter.INSTANCE.convertDTOToBO(practiceSetDTO);
            return Result.ok(practiceSetDomainService.update(practiceSetBO));
        } catch (Exception e) {
            log.error("PracticeSetController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新套题信息表信息失败");
        }

    }

    /**
     * 删除套题信息表
     */
    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody PracticeSetDTO practiceSetDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("PracticeSetController.delete.dto:{}", JSON.toJSONString(practiceSetDTO));
            }
            Preconditions.checkNotNull(practiceSetDTO.getId(), "主键不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetName(), "套题名称不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetType(), "套题类型 1实时生成 2预设套题不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetHeat(), "热度不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getSetDesc(), "套题描述不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getPrimaryCategoryId(), "大类id不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedBy(), "创建人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getCreatedTime(), "创建时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateBy(), "更新人不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getUpdateTime(), "更新时间不能为空");
            Preconditions.checkNotNull(practiceSetDTO.getIsDeleted(), "是否被删除 0为删除 1已删除不能为空");
            PracticeSetBO practiceSetBO = PracticeSetDTOConverter.INSTANCE.convertDTOToBO(practiceSetDTO);
            return Result.ok(practiceSetDomainService.delete(practiceSetBO));
        } catch (Exception e) {
            log.error("PracticeSetController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除套题信息表信息失败");
        }

    }

}
