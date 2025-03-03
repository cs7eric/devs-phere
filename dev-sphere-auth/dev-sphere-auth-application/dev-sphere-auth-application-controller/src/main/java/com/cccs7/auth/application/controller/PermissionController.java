package com.cccs7.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cccs7.auth.application.convert.AuthPermissionDTOConverter;
import com.cccs7.auth.application.dto.AuthPermissionDTO;
import com.cccs7.auth.entity.AuthPermissionBO;
import com.cccs7.auth.entity.Result;
import com.cccs7.auth.service.AuthPermissionDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限 controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/03
 */
@Slf4j
@RestController
@RequestMapping("/permission/")
public class PermissionController {

    @Resource
    private AuthPermissionDomainService authPermissionDomainService;

    /**
     * 添加权限
     *
     * @param authPermissionDTO 授权
     * @return {@link Result }
     */
    @PostMapping("add")
    public Result add(@RequestBody AuthPermissionDTO authPermissionDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.add.dto:{}", JSON.toJSONString(authPermissionDTO));
            }

            Preconditions.checkNotNull(authPermissionDTO.getParentId(), "权限父ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.dto2bo(authPermissionDTO);
            Boolean delete = authPermissionDomainService.add(authPermissionBO);
            return Result.ok(delete);
        } catch (Exception e) {
            log.error("RoleController.add.error:{}", e.getMessage(), e);
            return Result.fail("添加权限失败");
        }
    }

    /**
     * 更新用户权限信息
     *
     * @param authPermissionDTO 授权
     * @return {@link Result }
     */
    @PostMapping("update")
    public Result update(@RequestBody AuthPermissionDTO authPermissionDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.update.dto:{}", JSON.toJSONString(authPermissionDTO));
            }

            Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.dto2bo(authPermissionDTO);
            Boolean delete = authPermissionDomainService.update(authPermissionBO);
            return Result.ok(delete);
        } catch (Exception e) {
            log.error("RoleController.update.error:{}", e.getMessage(), e);
            return Result.fail("删除角色失败");
        }
    }


    /**
     * 删除权限
     *
     * @param authPermissionDTO 授权
     * @return {@link Result }
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody AuthPermissionDTO authPermissionDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.delete.dto:{}", JSON.toJSONString(authPermissionDTO));
            }

            Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.dto2bo(authPermissionDTO);
            Boolean delete = authPermissionDomainService.delete(authPermissionBO);
            return Result.ok(delete);
        } catch (Exception e) {
            log.error("RoleController.delete.error:{}", e.getMessage(), e);
            return Result.fail("删除角色失败");
        }
    }

    /**
     * 获得用户权限
     *
     * @param authPermissionDTO 授权
     * @return {@link Result }
     */
    @GetMapping("getPermission")
    public Result getPermission(@RequestBody AuthPermissionDTO authPermissionDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.getPermission.dto:{}", JSON.toJSONString(authPermissionDTO));
            }

            Preconditions.checkNotNull(authPermissionDTO.getId(), "ID不能为空");

            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.dto2bo(authPermissionDTO);
            AuthPermissionBO permissionBO = authPermissionDomainService.getPermission(authPermissionBO);
            AuthPermissionDTO permissionDTO = AuthPermissionDTOConverter.INSTANCE.bo2dto(permissionBO);
            return Result.ok(permissionDTO);
        } catch (Exception e) {
            log.error("RoleController.getPermission.error:{}", e.getMessage(), e);
            return Result.fail("获取角色权限失败");
        }
    }

}
