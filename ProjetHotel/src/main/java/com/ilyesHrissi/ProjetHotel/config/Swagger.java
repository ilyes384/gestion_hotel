package com.ilyesHrissi.ProjetHotel.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("Bearer"))
                .components(new Components().addSecuritySchemes("Bearer", createAPIKeyScheme()))
                .info(new Info().title("Projet de gestion d'hotel").version("V1"));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP).in(SecurityScheme.In.HEADER).name("Authorization")
                .scheme("bearer").bearerFormat("JWT");
    }
}
