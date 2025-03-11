package com.cccs7.subject.application.controller;

import com.cccs7.subject.application.convert.SubjectLabelDTOConverter;
import com.cccs7.subject.application.dto.SubjectLabelDTO;
import com.cccs7.subject.common.entity.Result;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.domain.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * 题目标签controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/10
 */
@Slf4j
@RestController
@RequestMapping("/subject/label/")
public class SubjectLabelController {


    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 添加标签
     *
     * @param subjectLabelDTO 题目标签
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result add(@RequestBody SubjectLabelDTO subjectLabelDTO) {

        try {
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getSortNum(), "排序权重不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类ID不能为空");

            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", subjectLabelDTO);
            }

            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.dto2bo(subjectLabelDTO);
            subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok("添加成功");
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error", e);
            return Result.fail("添加失败");
        }

    }

    /**
     * 更新标签
     *
     * @param subjectLabelDTO 主题标签
     * @return {@link Result }
     */
    @PostMapping("/update")
    public Result update(@RequestBody SubjectLabelDTO subjectLabelDTO) {

        Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签ID不能为空");

        if (log.isInfoEnabled()) {
            log.info("SubjectLabelController.update.dto:{}", subjectLabelDTO);
        }

        SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.dto2bo(subjectLabelDTO);
        int count = subjectLabelDomainService.update(subjectLabelBO);
        return count > 0 ? Result.ok("更新成功") : Result.fail("更新失败");

    }

    /**
     * 删除标签 - 逻辑删除
     *
     * @param subjectLabelDTO 主题标签
     * @return {@link Result }
     */
    @DeleteMapping("/delete")
    public Result delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {

        // 校验参数
        Preconditions.checkNotNull(subjectLabelDTO.getId(), "标签ID不能为空");

        if (log.isInfoEnabled()) {
            log.info("SubjectLabelController.delete.dto:{}", subjectLabelDTO);
        }

        SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.dto2bo(subjectLabelDTO);
        int delete = subjectLabelDomainService.delete(subjectLabelBO);
        return delete > 0 ? Result.ok("删除成功") : Result.fail("删除失败");
    }

    /**
     * 按分类id查询标签
     *
     * @param subjectLabelDTO 题目标签
     * @return {@link Result }<{@link List }<{@link Label }>>
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<Label>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {

        try {
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类ID不能为空");
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", subjectLabelDTO);
            }

            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.dto2bo(subjectLabelDTO);
            List<SubjectLabelBO> subjectLabelBOList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOS = SubjectLabelDTOConverter.INSTANCE.bos2dtos(subjectLabelBOList);
            return Result.ok(subjectLabelDTOS);
        } catch (Exception e) {
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }
    }

}
