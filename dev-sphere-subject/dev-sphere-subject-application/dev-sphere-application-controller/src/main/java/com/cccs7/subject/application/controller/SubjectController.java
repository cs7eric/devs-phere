package com.cccs7.subject.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 刷题 controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/01
 */
@RestController
public class SubjectController {

    @GetMapping("/test ")
    public String test(){
        return "hello";
    }

}
