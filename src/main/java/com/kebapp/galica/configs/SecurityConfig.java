/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.configs;

import com.kebapp.galica.security.BearerTokenAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;


/**
 *
 * @author denijal
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    BearerTokenAuthFilter bearerTokenAuthFilter;
    
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/public/**").permitAll(); /*  Без аутентификације пусти само захтеве ка 
                                                                           оним путањама које почињу са '/public/' */
                    request.anyRequest().authenticated(); // Остале прво аутентификуј
                })
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(bearerTokenAuthFilter, AuthorizationFilter.class); // Додај наш аутентификациони филтер
        return http.build();
    }

}
