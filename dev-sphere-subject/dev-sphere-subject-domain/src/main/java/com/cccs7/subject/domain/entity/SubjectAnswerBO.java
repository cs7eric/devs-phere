package com.cccs7.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/06
 */
@Data
public class SubjectAnswerBO implements Serializable {

    /**
     * 答案选项标识
     */
    private Integer optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;

}

