package com.cccs7.auth.config;

import com.cccs7.swagger.annotation.EnableCustomSwagger;
import com.cccs7.swagger.config.BaseSwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableCustomSwagger // 启用 Starter 的自动配置
public class SubjectSwaggerConfig extends BaseSwaggerConfig {

    @Override
    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Devsphere Auth Service API")
                .description("Auth API Documentation")
                .version("1.0.0")
                .build();
    }

    @Override
    public String getBasePackage() {
        return "com.cccs7.auth.application.controller";
    }

    @Bean
    public Docket authApi() {
        return super.createDocket("auth-service");
    }
}