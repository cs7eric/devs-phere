package com.cccs7.gateway.auth;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
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

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico")
                // 关键点：放行所有 OPTIONS 请求
                .setBeforeAuth(obj -> {
                    SaHolder.getResponse()

                            // ---------- 设置跨域响应头 ----------
                            // 允许指定域访问跨域资源
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "*")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                    ;

                    // 如果是预检请求，则立即返回到前端
                    SaRouter.match(SaHttpMethod.OPTIONS)
                            .free(r -> System.out.println("--------OPTIONS预检请求，不做处理"))
                            .back();

                });
//                .setAuth(obj -> {
//                    System.out.println("-------- 前端访问path：" + SaHolder.getRequest().getRequestPath());
//
//                    // 放行登录接口
//                    SaRouter.match("/auth/user/doLogin").free(r -> {
//                    });
//
//                    // 其他接口鉴权
//                    SaRouter.match("/auth/**", r -> StpUtil.checkRole("admin"));
//                    SaRouter.match("/oss/**", r -> StpUtil.checkLogin());
//                    SaRouter.match("/subject/subject/add", r -> StpUtil.checkPermission("subject:add"));
//                    SaRouter.match("/subject/**", r -> StpUtil.checkLogin());
//                });
    }
}