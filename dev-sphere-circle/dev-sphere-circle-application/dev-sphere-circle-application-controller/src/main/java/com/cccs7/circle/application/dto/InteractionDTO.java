package com.cccs7.circle.application.dto;

import lombok.Data;

@Data
public class InteractionDTO {
    private String userName;       // 用户ID
    private Long targetId;     // 目标ID（CirCle/文章ID/动态ID）
    private String targetType; // 目标类型（circle/article/moment/comment）
    private String actionType; // 操作类型（join/collect/like/favorite）
}