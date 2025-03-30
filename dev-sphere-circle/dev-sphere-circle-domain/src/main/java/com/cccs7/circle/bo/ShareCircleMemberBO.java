package com.cccs7.circle.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 圈子成员信息(ShareCircleMember) BO
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 22:09:18
 */
@Data
public class ShareCircleMemberBO implements Serializable {
    private static final long serialVersionUID = 321419416165706028L;
/**
     * ID
     */
    private Long id;
/**
     * 圈子id
     */
    private Long circleId;
/**
     * 用户id
     */
    private Long userId;
}

