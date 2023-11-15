package com.friedNote.friedNote_backend.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "FRIED NOTE API",
                description = "FRIED NOTE API 문서입니다.",
                version = "v1"),
        servers = {
                @Server(url = "3.39.220.111", description = "운영서버"),
                @Server(url = "http://localhost:8080", description = "로컬서버")
        }

)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi recipeOpenApi() {
        String[] paths = {"/recipe/**"};
        return GroupedOpenApi.builder()
                .group("Recipe API")
                .pathsToMatch(paths)
                .build();
    }

}
