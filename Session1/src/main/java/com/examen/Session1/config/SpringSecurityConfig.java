package com.examen.Session1.config;

import com.examen.Session1.security.JwtAuthenticationEntryPoint;
import com.examen.Session1.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// disable login form which provide the by spring security dependency.
@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Autowired
    JwtAuthenticationEntryPoint entryPoint;
    @Autowired
    JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/api/**").authenticated()  //what url need to secure
                                .requestMatchers("/auth/login").permitAll()
                                .requestMatchers("/post/**").permitAll()) //what url not secure
                .exceptionHandling(ex-> ex.authenticationEntryPoint(entryPoint))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
