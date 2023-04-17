package com.powerup.square.persistence.documentation;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Swagger url = http://localhost:8096/swagger-ui/index.html
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi(@Value("Square") String appDescription){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Game Project")
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

