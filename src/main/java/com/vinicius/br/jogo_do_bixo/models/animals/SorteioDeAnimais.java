package com.vinicius.br.jogo_do_bixo.models.animals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SorteioDeAnimais {


    @Autowired
    private AnimalRepository animalRepository;

    public AnimalDrawDTO draw(Animal animal){
        //validar
        animalRepository.updateDrawedAnimal(animal.getNome());
        return new AnimalDrawDTO(animal.getId(), animal.getNome());
    }

}
