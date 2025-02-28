package com.cccs7.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关 启动类
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/28
 */
@SpringBootApplication
@ComponentScan("com.cccs7")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
