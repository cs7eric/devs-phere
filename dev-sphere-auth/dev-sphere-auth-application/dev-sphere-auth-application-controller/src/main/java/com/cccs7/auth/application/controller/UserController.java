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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {

        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }

            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getEmail()), "邮件地址不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getPassword()), "密码不能为空");

            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.dto2bo(authUserDTO);

            Boolean registeredUser = authUserDomainService.register(authUserBO);

            return Result.ok(true);
        } catch (Exception e) {
            log.error("UserController.register.dto.error:{}", e.getMessage());
            return Result.fail(false);
        }


    }


}
