package com.cccs7.gateway.auth;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器 
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
            // 拦截地址 
            .addInclude("/**")
            // 开放地址 
            .addExclude("/favicon.ico")
            // 鉴权方法：每次访问进入 
            .setAuth(obj -> {

                System.out.println("-------- 前端访问path：" + SaHolder.getRequest().getRequestPath());


                SaRouter.match("/auth/**", "/auth/user/doLogin", r -> StpUtil.checkRole("admin"));
                SaRouter.match("/oss/**", r -> StpUtil.checkLogin());
                SaRouter.match("/subject/subject/add", r -> StpUtil.checkPermission("subject:add"));
                SaRouter.match("/subject/**", r -> StpUtil.checkLogin());

            })
            // 异常处理方法：每次setAuth函数出现异常时进入 
            .setError(e -> {
                return SaResult.error(e.getMessage());
            })
            ;
    }
}
