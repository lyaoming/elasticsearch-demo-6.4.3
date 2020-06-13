package com.esapplication.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口维护
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Value("${server.port}")
    String port;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.esapplication.Controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("Elastisearch测试")
                        .description("")
                        .version("1.0")
                        .contact(new Contact("lym","","1069878616@qq.com"))
                        .license("The Apache License")
                        .licenseUrl("http://localhost:"+port)
                        .build());
    }
}

