package com.cccs7.subject.common.util;


import com.cccs7.subject.common.context.LoginContextHolder;

/**
 * 用户登录 Util
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/22
 */
public class LoginUtil {

    public static String getLoginId() {

        return LoginContextHolder.getLoginId();
    }
}
