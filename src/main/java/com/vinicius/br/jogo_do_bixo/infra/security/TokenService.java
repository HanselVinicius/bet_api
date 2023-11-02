package com.vinicius.br.jogo_do_bixo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.vinicius.br.jogo_do_bixo.models.users.RegisterDTO;
import com.vinicius.br.jogo_do_bixo.models.users.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;
    public String geraToken(Usuario usuario){
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API jogo_do_bixo")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        }catch (JWTCreationException ex){
            throw new RuntimeException("Erro ao gerar o token jwt ",ex);
        }
    }

    public String getSubject(String tokenJWT){
        try{
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("API jogo_do_bixo")
                    .build()
                    //por algum motivo quando testo no insonmia alguns espaços em branco vem no ctr+v por isso esse .trim() aqui
                    .verify(tokenJWT.trim())
                    .getSubject();
        }catch (Exception ex){
            throw new RuntimeException("TOKEN JWT INVALIDO OU EXPIRADO ",ex);
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public Usuario getUser(RegisterDTO dto){
        var senha = new BCryptPasswordEncoder().encode(dto.password());
        return  new Usuario(dto.login(), senha, dto.cpf());
    }



}
