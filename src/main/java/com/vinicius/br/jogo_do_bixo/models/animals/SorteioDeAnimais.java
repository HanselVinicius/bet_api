package com.vinicius.br.jogo_do_bixo.models.animals;


import com.vinicius.br.jogo_do_bixo.models.animals.validadores.ValidadoresDeSorteio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SorteioDeAnimais {

    @Autowired
    private List<ValidadoresDeSorteio> validadores;


    @Autowired
    private AnimalRepository animalRepository;

    public AnimalDrawDTO draw(Animal animal){
        //validar
        validadores.forEach(v -> v.validar(animal));

        animalRepository.updateDrawedAnimal(animal.getNome());
        return new AnimalDrawDTO(animal.getId(), animal.getNome(), LocalDate.now());
    }

}
