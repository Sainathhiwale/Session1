package com.examen.Session1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@OpenAPIDefinition
public class SpringSwaggerConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorized -> authorized.anyRequest().authenticated() ).httpBasic(Customizer.withDefaults());
       return httpSecurity.build();
    }

    @Bean
    public OpenAPI baseOpenAPI(){
        return  new OpenAPI()
                .info(new Info().title("Employee Management").version("1.0.0").description("Rest API Backend Description"));
    }
}
