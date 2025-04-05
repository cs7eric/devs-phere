package com.cccs7.circle.common.enums;


import lombok.Getter;

/**
 * 交互类型枚举
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/04/05
 */
@Getter
public enum InteractionTypeEnum {

    ARTICLE(1, "文章"),
    MOMENT(2, "动态"),
    INTERVIEW_EXP(3, "面经");

    public int code;

    public String desc;

    InteractionTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static InteractionTypeEnum getByCode(int codeVal){
        for(InteractionTypeEnum resultCodeEnum : InteractionTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }

}
