package com.example.universidadSystem.universidad.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
                return new OpenAPI()
                                .info(new Info().title("API de Universidades de LATAM")
                                                .description("API para interactuar con toda la información de las univerisdades de LATAM")
                                                .version("v2.0.1")
                                                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                                .externalDocs(new ExternalDocumentation()
                                                .description("SpringShop Wiki Documentation")
                                                .url("https://springshop.wiki.github.org/docs"));
        }

        @Bean
        public RestTemplate restTemplate() {
                return new RestTemplate();
        }
}
