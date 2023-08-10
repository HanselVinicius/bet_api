package com.vinicius.br.jogo_do_bixo.models.animals;

import jakarta.validation.constraints.NotBlank;

public record AnimalRegisterDTO(
        @NotBlank
        String name) {
}
