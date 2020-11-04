package com.greencity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
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
                .apis(RequestHandlerSelectors.basePackage("andyfung026.gitbub.io"))
                .paths(PathSelectors.any())
                .build()
                ;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot中使用swagger2构建的RESTful APIs")
                .description("更多SpringBoot相关文章请自行百度")
                .termsOfServiceUrl("https://www.baidu.com")
                .contact("AndyFung")
                .version("1.0.0")
                .build()
                ;
    }

}
