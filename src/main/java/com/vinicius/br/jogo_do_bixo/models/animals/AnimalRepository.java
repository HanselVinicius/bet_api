package com.vinicius.br.jogo_do_bixo.models.animals;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    Animal findByNome(String nome);

    @Query("""
            SELECT a FROM Animal a
            ORDER BY RAND() LIMIT 1
            """)
    Animal findRandomAnimal();

    @Modifying
    @Transactional
    @Query("""
            UPDATE Animal a SET a.isOfTheDay = true,a.lastDayDrawed = CURDATE() WHERE a.nome = :nome
            """)
    void updateDrawedAnimal(@Param("nome") String nome);

    @Modifying
    @Transactional
    @Query("""
            UPDATE Animal a SET a.isOfTheDay = false WHERE a.isOfTheDay = true
            """)
    void updateIsOfTheDayToNull();

    @Query("""
            SELECT a FROM Animal a WHERE a.lastDayDrawed = CURDATE()
            """)
    Animal findTodayAnimal();
}
