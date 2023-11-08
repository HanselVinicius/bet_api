package com.vinicius.br.jogo_do_bixo.models.bet;

import com.vinicius.br.jogo_do_bixo.models.animals.AnimalRepository;
import com.vinicius.br.jogo_do_bixo.models.bet.validation.BetValidator;
import com.vinicius.br.jogo_do_bixo.models.users.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
        var login = SecurityContextHolder.getContext().getAuthentication().getName();
        var user =  usuarioRepository.findUserByLogin(login);
        var animal = animalRepository.findByNome(dto.nomeAnimal());
        betValidatorList.forEach(BetValidator::validate);
        usuarioRepository.updateLastBetDay(login);
        //rodar um update para lastBetDay do usuario
        return betRepository.save(new Bet(animal, user));
    }
}
