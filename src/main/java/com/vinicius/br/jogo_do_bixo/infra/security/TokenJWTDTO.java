package com.vinicius.br.jogo_do_bixo.infra.security;

import com.vinicius.br.jogo_do_bixo.models.users.Usuario;

public record TokenJWTDTO (
        String token,
        Usuario usuario){

}
