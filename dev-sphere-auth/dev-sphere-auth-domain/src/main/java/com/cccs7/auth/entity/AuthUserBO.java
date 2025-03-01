package com.cccs7.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 鉴权 用户 BO
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Data
public class AuthUserBO implements Serializable {


    private Long id;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private Integer sex;

    private String avatar;

    private Integer status;

    private String introduce;

    private String extJson;
}
