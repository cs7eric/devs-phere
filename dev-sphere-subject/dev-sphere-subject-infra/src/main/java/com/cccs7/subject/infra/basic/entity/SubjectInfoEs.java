package com.cccs7.subject.infra.basic.entity;

import com.cccs7.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SubjectInfoEs
        extends PageInfo implements Serializable {

    private Long subjectId;

    private Long docId;

    private String subjectName;

    private String subjectParse;

    private String subjectAnswer;

    private String createUser;

    private Long createTime;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;
}
