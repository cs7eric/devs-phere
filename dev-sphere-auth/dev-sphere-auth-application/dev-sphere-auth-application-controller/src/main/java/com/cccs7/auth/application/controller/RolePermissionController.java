package com.cccs7.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cccs7.auth.application.convert.AuthRolePermissionDTOConverter;
import com.cccs7.auth.application.dto.AuthRolePermissionDTO;
import com.cccs7.auth.entity.AuthRolePermissionBO;
import com.cccs7.auth.entity.Result;
import com.cccs7.auth.service.AuthRolePermissionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色权限controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/03
 */
@Slf4j
@RestController
@RequestMapping("/auth/rolePermission/")
public class RolePermissionController {

    @Resource
    private AuthRolePermissionDomainService authRolePermissionDomainService;


    /**
     * 新增角色权限关联关系
     *
     * @param authRolePermissionDTO 身份验证角色权限dto
     * @return {@link Result }
     */
    @PostMapping("add")
    public Result add (@RequestBody AuthRolePermissionDTO authRolePermissionDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RolePermissionController.add.dto:{}", JSON.toJSONString(authRolePermissionDTO));
            }

            Preconditions.checkArgument(!CollectionUtils.isEmpty(authRolePermissionDTO.getPermissionIdList()), "权限关联不能为空");
            Preconditions.checkNotNull(authRolePermissionDTO.getRoleId(),"角色不能为空");

            AuthRolePermissionBO authRolePermissionBO = AuthRolePermissionDTOConverter.INSTANCE.dto2bo(authRolePermissionDTO);

            Boolean add = authRolePermissionDomainService.add(authRolePermissionBO);
            return Result.ok(add);
        } catch (Exception e) {
            log.error("PermissionController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增失败，请重新尝试");

        }

    }
}
