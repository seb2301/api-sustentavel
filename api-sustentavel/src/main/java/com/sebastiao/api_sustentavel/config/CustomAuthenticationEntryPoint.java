package com.sebastiao.api_sustentavel.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // Define status 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // Define corpo da resposta
        response.getWriter().write("Erro 401: Autenticação necessária para acessar este recurso.");
    }
}
