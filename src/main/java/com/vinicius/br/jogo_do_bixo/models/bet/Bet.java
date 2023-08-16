package com.vinicius.br.jogo_do_bixo.models.bet;

import com.vinicius.br.jogo_do_bixo.models.animals.Animal;
import com.vinicius.br.jogo_do_bixo.models.users.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "bets")
@Entity(name = "Bet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate betDate;
    @OneToOne
    private Animal animal;
    @OneToOne
    private Usuario user;
    private LocalDate createdAt;
    private LocalDate deletedAt;

    public Bet(Animal animal, Usuario user) {
        this.animal = animal;
        this.user = user;
        this.betDate = LocalDate.now();
        this.createdAt = LocalDate.now();
        this.deletedAt = null;
    }
}
