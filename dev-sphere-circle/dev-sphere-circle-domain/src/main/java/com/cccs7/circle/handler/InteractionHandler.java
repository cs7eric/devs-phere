package com.cccs7.circle.handler;

import com.cccs7.circle.bo.InteractionBO;
import com.cccs7.circle.common.enums.InteractionTypeEnum;

public interface InteractionHandler {

    /**
     * 获取处理程序类型
     *
     * @return {@link InteractionTypeEnum }
     */
    InteractionTypeEnum getHandlerType();

    /**
     * 点赞
     *
     * @param interactionBO 相互作用波
     */
    void like(InteractionBO  interactionBO);

    /**
     * 收藏
     *
     * @param interactionBO 相互作用波
     */
    void collect(InteractionBO  interactionBO);

    /**
     * 评论
     *
     * @param interactionBO 相互作用波
     */
    void comment(InteractionBO  interactionBO);

    /**
     * 加入
     *
     * @param interactionBO 相互作用波
     */
    void join(InteractionBO  interactionBO);

}
