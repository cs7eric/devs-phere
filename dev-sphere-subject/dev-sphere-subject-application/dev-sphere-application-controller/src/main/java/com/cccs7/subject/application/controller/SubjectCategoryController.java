package com.cccs7.subject.application.controller;

import com.cccs7.subject.application.convert.SubjectCategoryDTOConverter;
import com.cccs7.subject.application.dto.SubjectCategoryDTO;
import com.cccs7.subject.common.entity.Result;
import com.cccs7.subject.common.enums.CategoryTypeEnum;
import com.cccs7.subject.domain.entity.SubjectCategoryBO;
import com.cccs7.subject.domain.service.SubjectCategoryDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 题目分类 controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/02
 */
@Slf4j
@RestController
@RequestMapping("/subject/category")
public class SubjectCategoryController {


    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 添加
     *
     * @param subjectCategoryDTO 主题类别dto
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.params:{}", subjectCategoryDTO);
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id 不能为空");


            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.dto2bo(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);

            return Result.ok(true);
        } catch (Exception e) {
            log.error("subjectCategoryController.add.error:{}", e.getMessage());
            return Result.fail(false);
        }
    }


    /**
     * 更新类别
     *
     * @param subjectCategoryDTO 主题类别dto
     * @return {@link Result }<{@link Boolean }>
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        SubjectCategoryBO subjectCategoryBO = null;
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.params:{}", subjectCategoryDTO);
            }

            subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.dto2bo(subjectCategoryDTO);
            return Result.ok(subjectCategoryDomainService.update(subjectCategoryBO));


        } catch (Exception e) {
            log.error("subjectCategoryController.add.error:{}", e.getMessage());
            return Result.fail(subjectCategoryDomainService.update(subjectCategoryBO));
        }
    }

    /**
     * 查询大类类别
     *
     * @param subjectCategoryDTO 主题类别dto
     * @return {@link Result }<{@link List }<{@link SubjectCategoryDTO }>>
     */
    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryPrimaryCategory.dto:{}", subjectCategoryDTO);
            }

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.dto2bo(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOS = SubjectCategoryDTOConverter.INSTANCE.bos2dtos(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOS);

        } catch (Exception e) {
            log.error("subjectCategoryController.add.error:{}", e.getMessage());
            List<SubjectCategoryDTO> subjectCategoriesDTO = Collections.emptyList();
            return Result.fail(subjectCategoriesDTO);
        }
    }

    /**
     * 按大类分类查询分类
     *
     * @param subjectCategoryDTO 主题类别dto
     * @return {@link Result }<{@link List }<{@link SubjectCategoryDTO }>>
     */
    @GetMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}", subjectCategoryDTO);
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类ID不能为空");

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.dto2bo(subjectCategoryDTO);
            subjectCategoryBO.setCategoryType(CategoryTypeEnum.PRIMARY.getCode());
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOS = SubjectCategoryDTOConverter.INSTANCE.bos2dtos(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOS);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);

            return Result.fail("查询失败");
        }
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {

        // 校验 ID 是否为空
        Preconditions.checkNotNull(subjectCategoryDTO.getId(), "ID 不能为空");

        if (log.isInfoEnabled()) {
            log.info("subjectCategoryController.delete.dto:{}", subjectCategoryDTO);
        }

        SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.dto2bo(subjectCategoryDTO);
        boolean deleted = subjectCategoryDomainService.delete(subjectCategoryBO);

        return deleted ? Result.ok(true) : Result.fail(false);
    }


}
