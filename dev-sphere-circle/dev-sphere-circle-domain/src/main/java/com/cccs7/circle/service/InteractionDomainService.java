package com.cccs7.circle.service;

import com.cccs7.circle.bo.InteractionBO;

public interface InteractionDomainService {

    void like(InteractionBO interactionBO);

    void collect(InteractionBO interactionBO);

    void join(InteractionBO interactionBO);

    void comment(InteractionBO interactionBO);
}
