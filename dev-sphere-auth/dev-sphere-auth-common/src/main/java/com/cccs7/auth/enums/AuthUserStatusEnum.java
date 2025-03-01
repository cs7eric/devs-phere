package com.cccs7.auth.enums;

import lombok.Getter;

/**
 * 授权用户状态enum
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Getter
public enum AuthUserStatusEnum {

    OPEN(0, "未删除"),
    CLOSE(1, "已删除");

    public int code;

    public String desc;

    AuthUserStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }
}
