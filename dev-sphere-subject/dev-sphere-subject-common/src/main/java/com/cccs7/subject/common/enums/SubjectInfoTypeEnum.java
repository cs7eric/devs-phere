package com.cccs7.subject.common.enums;

import lombok.Getter;

/**
 * 题目类型枚举
 * 1单选 2多选 3判断 4简答
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/15
 */
@Getter
public enum SubjectInfoTypeEnum {

    RADIO(1,"单选"),
    MULTIPLE(2,"多选"),
    JUDGE(3,"判断"),
    BRIEF(4,"简答"),
    SCENE(5,"场景题"),
    ;

    public int code;

    public String desc;

    SubjectInfoTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for(SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
