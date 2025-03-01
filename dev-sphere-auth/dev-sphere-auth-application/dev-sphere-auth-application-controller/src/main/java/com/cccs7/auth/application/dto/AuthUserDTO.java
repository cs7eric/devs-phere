package com.cccs7.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 授权用户dto
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Data
public class AuthUserDTO implements Serializable {

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
