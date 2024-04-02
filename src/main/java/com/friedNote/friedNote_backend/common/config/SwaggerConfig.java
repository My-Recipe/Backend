package com.friedNote.friedNote_backend.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@OpenAPIDefinition(
        info = @Info(
                title = "FRIED NOTE API",
                description = "FRIED NOTE API 문서입니다.",
                version = "v1")
)

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi recipeOpenApi() {
        String[] paths = {"/recipe/**"};
        return GroupedOpenApi.builder()
                .headersToMatch()
                .group("Recipe API")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi userOpenApi() {
        String[] paths = {"/user/**"};
        return GroupedOpenApi.builder()
                .group("User API")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi recipeBookOpenApi() {
        String[] paths = {"/recipeBook/**"};
        return GroupedOpenApi.builder()
                .group("RecipeBook API")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi inventoryOpenApi() {
        String[] paths = {"/inventory/**"};
        return GroupedOpenApi.builder()
                .group("Inventory API")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi bookmarkOpenApi() {
        String[] paths = {"/bookmark/**"};
        return GroupedOpenApi.builder()
                .group("Bookmark API")
                .pathsToMatch(paths)
                .addOpenApiCustomizer(buildSecurityOpenApi())
                .build();
    }

    //@Bean
    public GroupedOpenApi alarmOpenApi() {
        String[] paths = {"/alarm/**"};
        return GroupedOpenApi.builder()
                .group("Alarm API")
                .pathsToMatch(paths)
                .build();
    }

    public OpenApiCustomizer buildSecurityOpenApi() {
        return OpenApi -> OpenApi.addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents()
                .addSecuritySchemes("jwt token", new SecurityScheme()
                        .name("Authorization")
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER)
                        .bearerFormat("JWT")
                        .scheme("bearer"));
    }


    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }
}
