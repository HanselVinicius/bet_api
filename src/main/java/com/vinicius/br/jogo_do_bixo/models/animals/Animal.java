package com.vinicius.br.jogo_do_bixo.models.animals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "animals")
@Entity(name = "Animal")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Boolean isOfTheDay;
    private LocalDate createdAt;

    public Animal(AnimalRegisterDTO dto) {
        this.nome = dto.name();
        this.isOfTheDay = false;
        this.createdAt = LocalDate.now();

    }
}
