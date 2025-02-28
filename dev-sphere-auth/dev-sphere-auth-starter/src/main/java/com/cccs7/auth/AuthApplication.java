package com.cccs7.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主题应用程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/01
 */
@SpringBootApplication
@ComponentScan("com.cccs7")
@MapperScan("com.cccs7.**.mapper")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
