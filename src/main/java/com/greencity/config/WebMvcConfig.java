package com.greencity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/11/4/004 9:54
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    HandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("添加拦截器");
        registry.addInterceptor(handlerInterceptor)
        .addPathPatterns("/**");
    }
}
