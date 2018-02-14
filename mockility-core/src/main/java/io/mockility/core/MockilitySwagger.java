package io.mockility.core;

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
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */

@EnableSwagger2
@Configuration
public class MockilitySwagger {

    @Bean
    public Docket createDocket() {
        ApiInfo apiInfo = getApiInfo();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.mockility.rest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Mockility API Document")
                .description("this is a description")
                .contact("Liang Wei")
                .license("MIT")
                .licenseUrl("")
                .version("1.0")
                .build();
    }
}
