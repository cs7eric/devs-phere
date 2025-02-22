package com.cccs7.oss;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * oss应用程序
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/22
 */
@SpringBootApplication
@ComponentScan("com.cccs7")
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }

}
