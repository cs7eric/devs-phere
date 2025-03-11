package com.cccs7.swagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Docket defaultDocket() {

        return new BaseSwaggerConfig() {

            @Override
            public String getBasePackage() {
                return "cccs7";
            }
        }.createDocket("default");
    }
}