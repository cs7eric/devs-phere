package com.cccs7.auth.service;

import com.cccs7.auth.entity.AuthPermissionBO;

public interface AuthPermissionDomainService {
    Boolean add(AuthPermissionBO authPermissionBO);

    Boolean delete(AuthPermissionBO authPermissionBO);

    AuthPermissionBO getPermission(AuthPermissionBO authPermissionBO);

    Boolean update(AuthPermissionBO authPermissionBO);
}
