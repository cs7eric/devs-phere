package com.cccs7.gateway.fliter;


import cn.dev33.satoken.stp.StpUtil;
import com.cccs7.gateway.redis.RedisUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 登录拦截器
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/22
 */
@Slf4j
@Component
public class LoginFilter implements GlobalFilter {

    @Resource
    private RedisUtil redisUtil;


    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        log.info("LoginFilter.filter.url:{}", url);
        if (url.equals("/auth/user/doLogin")) {
            return chain.filter(exchange);
        }

        String loginId = request.getHeaders().getFirst("loginId");

        boolean login = StpUtil.isLogin(loginId);
        if (!login) {
            throw new Exception("未获取到用户信息");

        }
        mutate.header("loginId", String.valueOf(loginId));
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }
}
