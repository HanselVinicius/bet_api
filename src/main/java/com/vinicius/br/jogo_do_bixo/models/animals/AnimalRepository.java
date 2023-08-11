package com.vinicius.br.jogo_do_bixo.models.animals;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Animal findByNome(String nome);

    @Query("""
            SELECT * FROM animals
            ORDER BY RAND() LIMIT 1
            """)
    Animal findRandomAnimal();
}
