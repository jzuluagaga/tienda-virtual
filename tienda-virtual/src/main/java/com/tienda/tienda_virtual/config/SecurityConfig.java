package com.tienda.tienda_virtual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactivar CSRF
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/registro", "/login", "/usuario/**", "/carrito/**", "/images/**", "/static/**", "/css/**", "/js/**", "/style.css", "/bienvenida", "/hombre", "/mujer", "/productos", "/producto/**", "/buscar").permitAll()
                .requestMatchers("/carrito/agregar").permitAll() // Permitir método POST en /carrito/agregar
                .anyRequest().authenticated()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}






