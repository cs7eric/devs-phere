package com.cccs7.subject.application.controller;

import com.cccs7.subject.application.convert.SubjectAnswerDTOConverter;
import com.cccs7.subject.application.convert.SubjectInfoDTOConverter;
import com.cccs7.subject.application.dto.SubjectInfoDTO;
import com.cccs7.subject.common.entity.PageResult;
import com.cccs7.subject.common.entity.Result;
import com.cccs7.subject.domain.entity.SubjectAnswerBO;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.service.SubjectInfoDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题 controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/01
 */
@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {


    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * 添加题目
     *
     * @param subjectInfoDTO 题目DTO
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", subjectInfoDTO);
            }

            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectParse()), "题目解析不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()), "分类ID不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()), "标签ID不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.dto2bo(subjectInfoDTO);

            List<SubjectAnswerBO> subjectAnswerBOList
                    = SubjectAnswerDTOConverter.INSTANCE.dtos2bos(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOList);
            subjectInfoDomainService.add(subjectInfoBO);

            return Result.ok(true);
        } catch (Exception e) {
            log.error("subjectCategoryController.add.error:{}", e.getMessage());
            return Result.fail(false);
        }
    }


    /**
     * 查询题目列表
     *
     * @param subjectInfoDTO 题目信息dto
     * @return {@link Result }<{@link PageResult }<{@link SubjectInfo }>>
     */
    @GetMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.getSubjectPage.dto:{}", subjectInfoDTO);
            }

            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "标签ID不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "分类ID不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.dto2bo(subjectInfoDTO);
            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);

            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("subjectCategoryController.getSubjectPage.error:{}", e.getMessage());
            return Result.fail(null);
        }
    }

    /**
     * 查询题目信息
     *
     * @param subjectInfoDTO 题目信息dto
     * @return {@link Result }<{@link SubjectInfoDTO }>
     */
    @GetMapping("/getSubjectInfo")
    public Result<SubjectInfoDTO> getSubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.getSubjectPage.dto:{}", subjectInfoDTO);
            }

            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConverter.INSTANCE.dto2bo(subjectInfoDTO);
            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO infoDTO = SubjectInfoDTOConverter.INSTANCE.bo2dto(boResult);
            return Result.ok(infoDTO);
        } catch (Exception e) {
            log.error("subjectCategoryController.getSubjectPage.error:{}", e.getMessage());
            return Result.fail("查询题目详情失败");
        }
    }

}
