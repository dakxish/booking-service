package com.myflight.book.bookingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerApiImpl(){

        return  new Docket(DocumentationType.SWAGGER_2)
//                .groupName("booking-service-api")
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.myflight.book.bookingservice.controller.impl"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo getApiInfo(){

        return new ApiInfoBuilder()
                .description("Booking service API")
                .contact(new Contact("Indifo", "www.myindifo.com", "abc@indifo.com"))
                .version("1.0")
                .license("Apache open source")
                .licenseUrl("abc.com")
                .title("This is Booking service API for Indifo")
                .extensions(Collections.emptyList())
                .build();
    }
}
