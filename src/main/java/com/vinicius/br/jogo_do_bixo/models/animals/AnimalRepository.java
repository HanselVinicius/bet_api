package com.vinicius.br.jogo_do_bixo.models.animals;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Animal findByNome(String nome);
}
