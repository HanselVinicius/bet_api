package com.vinicius.br.jogo_do_bixo.controllers;

import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DrawController {


    @Autowired
    private AnimalRepository animalRepository;


    @Scheduled(fixedRate = 86400)
    public void drawAnimal(){
        animalRepository.updateIsOfTheDayToNull();
        var animal = animalRepository.findRandomAnimal();
        animalRepository.updateDrawedAnimal(animal.getNome());
        System.out.println("Animal sorteado");
    }

}
