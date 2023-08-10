package com.vinicius.br.jogo_do_bixo.models.animals;

import java.time.LocalDate;

public record DetailAnimalDTO(Long id,
                              String nome,
                              Boolean isOfTheDay,
                              LocalDate createdAt) {


    public DetailAnimalDTO(Animal animal){
        this(animal.getId(), animal.getNome(), animal.getIsOfTheDay(),animal.getCreatedAt());
    }
}

