package com.cccs7.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cccs7.auth.application.convert.AuthRoleDTOConverter;
import com.cccs7.auth.application.dto.AuthRoleDTO;
import com.cccs7.auth.entity.AuthRoleBO;
import com.cccs7.auth.entity.Result;
import com.cccs7.auth.service.AuthRoleDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/02
 */
@Slf4j
@RestController
@RequestMapping("/auth/role/")
public class RoleController {

    @Resource
    private AuthRoleDomainService authRoleDomainService;


    /**
     * 添加角色
     *
     * @param authRoleDTO Auth角色
     * @return {@link Result }
     */
    @PostMapping("add")
    public Result add(@RequestBody AuthRoleDTO authRoleDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.add.dto:{}", JSON.toJSONString(authRoleDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(authRoleDTO.getRoleName()), "角色名称不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(authRoleDTO.getRoleKey()), "角色Key不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.dto2bo(authRoleDTO);
            Boolean count = authRoleDomainService.add(authRoleBO);
            return Result.ok(count);
        } catch (Exception e) {
            log.error("RoleController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增角色失败");
        }
    }

    /**
     * 更新角色信息
     *
     * @param authRoleDTO Auth角色
     * @return {@link Result }
     */
    @PostMapping("update")
    public Result update(@RequestBody AuthRoleDTO authRoleDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.update.dto:{}", JSON.toJSONString(authRoleDTO));
            }

            Preconditions.checkNotNull(authRoleDTO.getId(), "ID不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.dto2bo(authRoleDTO);
            Boolean update = authRoleDomainService.update(authRoleBO);
            return Result.ok(update);
        } catch (Exception e) {
            log.error("RoleController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新信息失败");
        }
    }

    /**
     * 删除角色信息
     *
     * @param authRoleDTO Auth角色
     * @return {@link Result }
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody AuthRoleDTO authRoleDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.delete.dto:{}", JSON.toJSONString(authRoleDTO));
            }

            Preconditions.checkNotNull(authRoleDTO.getId(), "ID不能为空");

            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.dto2bo(authRoleDTO);
            Boolean delete = authRoleDomainService.delete(authRoleBO);
            return Result.ok(delete);
        } catch (Exception e) {
            log.error("RoleController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除角色失败");
        }
    }


}
