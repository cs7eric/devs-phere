package com.cccs7.circle.application.dto;

import lombok.Data;

import java.util.List;

/**
 * 圈子行为dto
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
@Data
public class CircleActionDTO {

    private Long id;

    /**
     * 用户ID
     */
    private String userName;


    /**
     * 圈子ID
     */
    private Long circleId;


    /**
     * 圈子成员列表
     */
    private List<ShareCircleMemberDTO> circleMemberList;


    /**
     * 圈子名字
     */
    private String circleName;
}
