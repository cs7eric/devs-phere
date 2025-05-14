package com.cccs7.circle.application.controller;

import com.cccs7.circle.application.convert.ArticleDTOConverter;
import com.cccs7.circle.application.dto.ShareArticleDTO;
import com.cccs7.circle.bo.ShareArticleBO;
import com.cccs7.circle.common.entity.Result;
import com.cccs7.circle.service.ShareArticleDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/share/article/")
public class ArticleController {

    @Resource
    private ShareArticleDomainService articleDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody ShareArticleDTO shareArticleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("ArticleController.add.dto:{}", shareArticleDTO);
            }

            Preconditions.checkNotNull(shareArticleDTO.getTitle(), "文章标题不能为空");
            Preconditions.checkNotNull(shareArticleDTO.getContent(), "文章内容不能为空");
            Preconditions.checkNotNull(shareArticleDTO.getUserName(), "作者名不能为空");
            Preconditions.checkNotNull(shareArticleDTO.getCircleId(), "所属圈子不能为空");
            Preconditions.checkNotNull(shareArticleDTO.getLabelList(), "标签不能为空");


            ShareArticleBO articleBO = ArticleDTOConverter.INSTANCE.dto2bo(shareArticleDTO);
            boolean result = articleDomainService.add(articleBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("ArticleController.add.error", e);
            return Result.fail(false);
        }
    }

    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody ShareArticleDTO shareArticleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("ArticleController.update.dto:{}", shareArticleDTO);
            }

            Preconditions.checkNotNull(shareArticleDTO.getId(), "文章ID不能为空");

            ShareArticleBO articleBO = ArticleDTOConverter.INSTANCE.dto2bo(shareArticleDTO);
            boolean result = articleDomainService.update(articleBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("ArticleController.update.error", e);
            return Result.fail(false);
        }
    }

    /**
     * 查询
     *
     * @param shareArticleDTO 分享文章
     * @return {@link Result }<{@link List }<{@link ShareArticleDTO }>>
     */
    @PostMapping("/query")
    public Result<List<ShareArticleDTO>> query(@RequestBody ShareArticleDTO shareArticleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("ArticleController.query.dto:{}", shareArticleDTO);
            }
            ShareArticleBO articleBO =ArticleDTOConverter.INSTANCE.dto2bo(shareArticleDTO);
            List<ShareArticleBO> articleBOList = articleDomainService.query(articleBO);
            List<ShareArticleDTO> dtoList = ArticleDTOConverter.INSTANCE.bos2dtos(articleBOList);
            return Result.ok(dtoList);
        } catch (Exception e) {
            log.error("ArticleController.query.error", e);
            return Result.fail(Collections.emptyList());
        }
    }

    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody ShareArticleDTO shareArticleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("ArticleController.delete.dto:{}", shareArticleDTO);
            }

            Preconditions.checkNotNull(shareArticleDTO.getId(), "文章ID不能为空");

            ShareArticleBO articleBO = ArticleDTOConverter.INSTANCE.dto2bo(shareArticleDTO);
            boolean result = articleDomainService.delete(articleBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("ArticleController.delete.error", e);
            return Result.fail(false);
        }
    }

    /**
     * 查询文章通过圈子ID
     *
     * @param shareArticleDTO 分享文章
     * @return {@link Result }<{@link List }<{@link ShareArticleDTO }>>
     */
    @PostMapping("/getArticleByCircle")
    public Result<List<ShareArticleDTO>> getArticleByCircle(@RequestBody ShareArticleDTO shareArticleDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("ArticleController.getArticleByCircle.dto:{}", shareArticleDTO);
            }

            ShareArticleBO articleBO =ArticleDTOConverter.INSTANCE.dto2bo(shareArticleDTO);
            List<ShareArticleBO> articleBOList = articleDomainService.getArticleByCircle(articleBO);
            List<ShareArticleDTO> dtoList = ArticleDTOConverter.INSTANCE.bos2dtos(articleBOList);
            return Result.ok(dtoList);
        } catch (Exception e) {
            log.error("ArticleController.query.error", e);
            return Result.fail(Collections.emptyList());
        }
    }

}
