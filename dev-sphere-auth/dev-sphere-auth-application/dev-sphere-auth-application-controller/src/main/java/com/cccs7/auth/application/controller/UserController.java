package com.cccs7.auth.application.controller;

import com.alibaba.fastjson.JSON;
import com.cccs7.auth.application.convert.AuthUserDTOConverter;
import com.cccs7.auth.application.dto.AuthUserDTO;
import com.cccs7.auth.entity.AuthUserBO;
import com.cccs7.auth.entity.Result;
import com.cccs7.auth.service.AuthUserDomainService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    /**
     * 用户注册
     *
     * @param authUserDTO 授权用户dto
     * @return {@link Result }
     */
    @PostMapping("register")
    public Result register(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }

            checkUserInfo(authUserDTO);
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getEmail()), "邮件地址不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getPassword()), "密码不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);

            Boolean registeredUser = authUserDomainService.register(authUserBO);

            if (!registeredUser) {
                return Result.fail("注册失败，请重新尝试");
            }

        } catch (Exception e) {
            log.error("UserController.register.dto.error:{}", e.getMessage());
            return Result.fail("注册失败，请重新尝试");
        }
        return Result.ok(true);
    }

    /**
     * 更新用户信息
     *
     * @param authUserDTO 授权用户dto
     * @return {@link Result }
     */
    @PostMapping("update")
    public Result update(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto:{}", JSON.toJSONString(authUserDTO));
            }

            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);
            return Result.ok( authUserDomainService.update(authUserBO));


        } catch (Exception e) {
            log.error("UserController.update.dto.error:{}", e.getMessage());
            return Result.fail("更新用户信息失败，请重新尝试");
        }
    }

    @DeleteMapping("delete")
    public Result delete(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.delete.dto:{}", JSON.toJSONString(authUserDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getId().toString()), "ID不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);
            return Result.ok( authUserDomainService.delete(authUserBO));


        } catch (Exception e) {
            log.error("UserController.delete.dto.error:{}", e.getMessage());
            return Result.fail("删除用户失败，请重新尝试");
        }
    }

    /**
     * 用户启用/禁用
     *
     * @param authUserDTO 授权用户dto
     * @return {@link Result }
     */
    @PostMapping("changeStatus")
    public Result changeStatus(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.changeStatus.dto:{}", JSON.toJSONString(authUserDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getId().toString()), "ID不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);
            return Result.ok( authUserDomainService.changeStatus(authUserBO));


        } catch (Exception e) {
            log.error("UserController.changeStatus.dto.error:{}", e.getMessage(), e);
            return Result.fail("更新失败，请重新尝试");
        }
    }

    /**
     * 获取用户信息
     *
     * @param authUserDTO 授权用户dto
     * @return {@link Result }
     */
    @GetMapping("getUserInfo")
    public Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getUserInfo.dto:{}", JSON.toJSONString(authUserDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getId().toString()), "ID不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);

            AuthUserBO userInfo =  authUserDomainService.getUserInfo(authUserBO);
            return Result.ok(userInfo);

        } catch (Exception e) {
            log.error("UserController.getUserInfo.dto.error:{}", e.getMessage(), e);
            return Result.fail("查询失败，请重新尝试");
        }
    }



    public void checkUserInfo(AuthUserDTO authUserDTO){

        Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
    }


}
