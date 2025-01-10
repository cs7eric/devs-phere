package com.cccs7.subject.common.enums;

import lombok.Getter;

/**
 * 分类类型枚举
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/09
 */
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1, "一级大类"),
    SECOND(2, "二级分类");

    public int code;

    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static CategoryTypeEnum getByCode(int codeVal){
        for(CategoryTypeEnum resultCodeEnum : CategoryTypeEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
