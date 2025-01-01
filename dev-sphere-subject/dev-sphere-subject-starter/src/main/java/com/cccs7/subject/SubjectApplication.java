package com.cccs7.subject;


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
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }

}
