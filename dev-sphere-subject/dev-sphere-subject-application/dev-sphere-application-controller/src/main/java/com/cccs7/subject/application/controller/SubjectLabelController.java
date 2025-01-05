package com.cccs7.subject.application.controller;

import com.cccs7.subject.application.convert.SubjectLabelDTOConverter;
import com.cccs7.subject.application.dto.SubjectLabelDTO;
import com.cccs7.subject.common.entity.Result;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.domain.service.SubjectLabelDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/subject/label/")
public class SubjectLabelController {


    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO){

        try {
            Preconditions.checkArgument(!StringUtils.isBlank(subjectLabelDTO.getLabelName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getSortNum(), "排序权重不能为空");
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "分类ID不能为空");

            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.dto:{}", subjectLabelDTO);
            }

            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.dto2bo(subjectLabelDTO);
            subjectLabelDomainService.add(subjectLabelBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectLabelController.add.error", e);
            return Result.fail(false);
        }

    }
}
