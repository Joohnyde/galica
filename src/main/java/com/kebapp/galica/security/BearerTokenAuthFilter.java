/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kebapp.galica.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author denijal
 */

/*
    Ово је наш аутентификациони филтер. Његов посао је да из заглавља прочита токен.
Токен се налази у заглављу "Authorization" и у облику је "Bearer xxx" ге су xxx заправо токен.
Након извлачења токена, из application.yml се чита вредност admin.password. Уколико се она не
  поклапа са токеном, баци 401 (неауторизован) одговор. У супротном пропусти захтев даље.
*/
@Component
public class BearerTokenAuthFilter extends OncePerRequestFilter {

    private static final Logger logger
            = LoggerFactory.getLogger(BearerTokenAuthFilter.class);
    
    @Value("${admin.password}")
    private String adminPassword;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ") && !authHeader.substring(7).isBlank()) {
            String accessToken = authHeader.substring(7);

            logger.info("Authorization attempted with token: " + accessToken);

            if (!adminPassword.equals(accessToken)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            } else {

                Authentication auth = new TokenAuthentication(accessToken); // Хардкодовани објекат аутентификације
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }
}
