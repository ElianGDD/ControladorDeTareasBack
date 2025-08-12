package com.digis.EDesalesTareaServidorAgosto11.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Alien 13
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.DELETE,"/tarea/BorrarTarea").permitAll()
                .requestMatchers(HttpMethod.PUT, "/tarea/ActualizarTarea").permitAll()
                .requestMatchers(HttpMethod.POST,"/tarea/ApregarNuevaTarea").permitAll()
                .requestMatchers(HttpMethod.GET, "/tarea").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
