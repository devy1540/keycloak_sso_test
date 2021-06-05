package com.example.sso_test.configuration.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("TestCase Backend Server")
                .version("v1")
                .description("Spring Boot를 이용한 QmartTM API Server")
                .contact(new Contact().name("윤혁준").email("gurwns1540.gmail.com"));

        return new OpenAPI().components(new Components())
                .info(info);
    }
}
