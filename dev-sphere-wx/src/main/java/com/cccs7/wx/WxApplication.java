package com.cccs7.wx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 微信服务应用程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/04
 */
@ComponentScan("com.cccs7")

@SpringBootApplication
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class);
    }

}
