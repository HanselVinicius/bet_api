package com.vinicius.br.jogo_do_bixo.models.animals.validadores;

import com.vinicius.br.jogo_do_bixo.infra.exceptions.ValidacaoException;
import com.vinicius.br.jogo_do_bixo.models.animals.Animal;
import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorJaEscolhidoHoje implements ValidadoresDeSorteio{

    @Autowired
    private AnimalRepository animalRepository;
    @Override
    public void validar(Animal animal) {
        if (animalRepository.findTodayAnimal() != null){
            throw new ValidacaoException("O ANIMAL DO DIA JA FOI ESCOLHIDO");
        }
    }
}
