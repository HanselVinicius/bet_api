package com.vinicius.br.jogo_do_bixo.models.animals;

import jakarta.validation.constraints.NotBlank;

public record AnimalDrawDTO(
        @NotBlank
        Long id,
        @NotBlank
        String nome) {
}
