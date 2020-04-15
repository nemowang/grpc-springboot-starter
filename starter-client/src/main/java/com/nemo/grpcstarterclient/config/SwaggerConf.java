package com.nemo.grpcstarterclient.config;

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
 * @author Nemo
 * @version 1.0
 * @date 2020/4/15
 */
@EnableSwagger2
@Configuration
public class SwaggerConf {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nemo.grpcstarterclient"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("gRpc-spring-boot-api")
                .description("gRpc整合Springboot api")
                .termsOfServiceUrl("")
                .contact(new Contact("Nemo", "cnblogs.com/nemowang1996/", "nemowang77@163.com"))
                .version("1.0")
                .build();
    }
}
