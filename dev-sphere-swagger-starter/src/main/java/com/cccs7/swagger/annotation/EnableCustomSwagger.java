package com.cccs7.swagger.annotation;

import com.cccs7.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SwaggerAutoConfiguration.class) // 导入自动配置
public @interface EnableCustomSwagger {
}