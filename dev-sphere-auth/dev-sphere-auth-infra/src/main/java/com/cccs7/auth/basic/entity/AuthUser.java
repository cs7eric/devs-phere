package com.cccs7.auth.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息表(AuthUser)实体类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-01 19:37:26
 */
@Data
public class AuthUser implements Serializable {
    private static final long serialVersionUID = 308340739496707678L;
/**
     * 主键
     */
    private Long id;
/**
     * 用户名称/账号
     */
    private String userName;
/**
     * 昵称
     */
    private String nickName;
/**
     * 邮箱
     */
    private String email;
/**
     * 手机号
     */
    private String phone;
/**
     * 密码
     */
    private String password;
/**
     * 性别
     */
    private Integer sex;
/**
     * 头像
     */
    private String avatar;
/**
     * 状态 0启用 1禁用
     */
    private Integer status;
/**
     * 个人介绍
     */
    private String introduce;
/**
     * 特殊字段
     */
    private String extJson;
/**
     * 创建人
     */
    private String createdBy;
/**
     * 创建时间
     */
    private Date createdTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;
/**
     * 是否被删除 0未删除 1已删除
     */
    private Integer isDeleted;

}

