package com.xinrui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*普通通用api， 通过头部下拉框来切换*/
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("study")
                .apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any())//对所有api进行监控
                .paths(regex("/xinrui/study/.*")) // 对所有路径进行监控
                .build();
    }

    /*使用Admin时展现的API*/
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/xinrui/demo/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("欢迎来到新瑞学习demo页面")
                .description("运气比努力重要,但是只有努力是你可以掌握的,而选择的对错是你努力学习后才能真正看清的.")
                .termsOfServiceUrl("https://github.com")
                .contact(new Contact("组织名称", "https://github.com/dashboard","645044608@qq.com"))
                .license("新瑞个人学习专用demo")
                .version("1.0")
                .build();
    }
}