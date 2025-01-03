package com.cccs7.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import com.cccs7.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test1(){

        return "hello";
    }


    @GetMapping("/1")
    public String hello(){
        return "1";
    }

    @GetMapping("id")
    public String query() {

        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);

        if (log.isInfoEnabled()){
            log.info("subjectCategoryController.query.entity:{}", JSON.toJSONString(subjectCategory));
        }
        System.out.println(subjectCategory);
        return "1";
    }

}
