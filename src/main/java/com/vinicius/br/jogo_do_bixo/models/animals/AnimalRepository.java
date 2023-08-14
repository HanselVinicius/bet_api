package com.vinicius.br.jogo_do_bixo.models.animals;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Animal findByNome(String nome);

    @Query("""
            SELECT a FROM Animal a
            ORDER BY RAND() LIMIT 1
            """)
    Animal findRandomAnimal();

    @Modifying
    @Query("""
            UPDATE Animal a SET a.isOfTheDay = true WHERE a.nome = :nome
            """)
    void updateDrawedAnimal(@Param("nome") String nome);
}
