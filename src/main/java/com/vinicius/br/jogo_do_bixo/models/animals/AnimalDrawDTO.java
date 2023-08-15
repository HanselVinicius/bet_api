package com.vinicius.br.jogo_do_bixo.models.animals;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AnimalDrawDTO(
        @NotBlank
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        LocalDate lastDayDrawed) {
}
