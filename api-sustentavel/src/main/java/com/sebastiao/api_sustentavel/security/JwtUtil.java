package com.sebastiao.api_sustentavel.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;


@Component
public class JwtUtil {

    // Chave secreta usada para assinar o JWT
    private final String SECRET_KEY = "minha_chave_secreta";  // Troque por uma chave mais segura em produção

    // Tempo de expiração do JWT (1 dia de expiração)
    private final long EXPIRATION_TIME = 86400000L; // 24h em milissegundos

    // Método para gerar o token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Define o nome do usuário no token
                .setIssuedAt(new Date()) // Data de emissão
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Define a data de expiração
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Assina o token com a chave secreta
                .compact();
    }

    // Método para extrair o nome de usuário do token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Método para extrair as claims do token (como o nome de usuário)
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Usando a chave secreta para validar
                .parseClaimsJws(token)
                .getBody(); // Retorna o corpo do token, que contém as claims
    }

    // Método para verificar se o token é válido
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date()); // Verifica se a data de expiração já passou
    }

    // Método para extrair a data de expiração do token
    private Date extractExpiration(String token) {
        return extractClaims(token).getExpiration();
    }

    // Método para validar o token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

}


