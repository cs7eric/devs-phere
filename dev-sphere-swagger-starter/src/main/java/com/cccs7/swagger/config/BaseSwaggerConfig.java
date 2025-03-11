package com.cccs7.swagger.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public abstract class BaseSwaggerConfig {

    // 基础配置方法，子类可覆盖
    protected ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Default API")
                .description("Default API Description")
                .version("1.0.0")
                .build();
    }

    // 创建 Docket 的通用逻辑
    public Docket createDocket(String groupName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }
    public abstract String getBasePackage();
}