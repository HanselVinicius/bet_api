package com.vinicius.br.jogo_do_bixo.models.bet;

import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRepository;
import com.vinicius.br.jogo_do_bixo.models.bet.validation.BetValidator;
import com.vinicius.br.jogo_do_bixo.models.users.Usuario;
import com.vinicius.br.jogo_do_bixo.models.users.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private List<BetValidator> betValidatorList;

    public Bet createBet(BetRegisterDTO dto) {
        var user =  usuarioRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        var animal = animalRepository.findByNome(dto.nomeAnimal());
        //validation
        betValidatorList.forEach(b-> b.validate());

        return new Bet(animal, (Usuario) user);
    }
}
