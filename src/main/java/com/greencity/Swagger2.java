package com.greencity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/10/28/028 14:52
 */
//让spring加载该配置类
@Configuration
//启用Swagger2
@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.greencity.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                ;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot中使用swagger2构建的RESTful APIs")
                .description("https://www.baidu.com")
                .contact(new Contact("AndyFung","https://andyfung026.github.io","zzAndyFung@163.com"))
                .version("1.0.0")
                .build()
                ;
    }

}
