package com.cccs7.subject.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * 题目BO
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/17
 */
@Data
public class SubjectOptionBO {

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;

}
