package com.sebastiao.api_sustentavel.controller;

import com.sebastiao.api_sustentavel.dto.AuthenticationRequest;
import com.sebastiao.api_sustentavel.dto.AuthenticationResponse;
import com.sebastiao.api_sustentavel.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {

        // Valida as credenciais do usuário
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            return ResponseEntity.status(401).build(); // 401 Unauthorized
        }

        // Se as credenciais forem válidas, gerar o token JWT
        final String token = jwtUtil.generateToken(authenticationRequest.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(token)); // Retorna o token gerado
    }
}
