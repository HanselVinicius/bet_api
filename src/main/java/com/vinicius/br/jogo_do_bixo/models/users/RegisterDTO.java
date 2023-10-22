package com.vinicius.br.jogo_do_bixo.models.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//TODO VALIDATION
public record RegisterDTO(
        @Email
        String login,
        @NotBlank
        String password,
        @NotBlank
        String cpf) {
}
