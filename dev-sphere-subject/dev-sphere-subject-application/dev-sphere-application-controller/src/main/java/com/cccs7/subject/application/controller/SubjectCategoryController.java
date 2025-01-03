package com.cccs7.subject.application.controller;

import com.cccs7.subject.application.dto.SubjectCategoryDTO;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/add")
    public String add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        if (log.isInfoEnabled()) {
            log.info("live");
        }
        return "ok";
    }
}
