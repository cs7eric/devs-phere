package com.cccs7.practice.common.enums;

import lombok.Getter;

@Getter
public enum IsDeletedFlagEnum {

    DELETED(1, "删除"),
    UN_DELETED(0, "未删除");

    public int code;

    public String desc;

    IsDeletedFlagEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if(resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
