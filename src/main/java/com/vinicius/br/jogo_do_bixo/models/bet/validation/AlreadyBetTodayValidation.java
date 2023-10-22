package com.vinicius.br.jogo_do_bixo.models.bet.validation;

import com.vinicius.br.jogo_do_bixo.infra.exceptions.ValidacaoException;
import com.vinicius.br.jogo_do_bixo.models.users.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AlreadyBetTodayValidation implements BetValidator{



    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validate() {
        var usuario = usuarioRepository.findUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if (usuario.getLastBetDay().getDayOfMonth() != LocalDate.now().getDayOfMonth()) {
            throw new ValidacaoException("USUARIO INFORMADO JA APOSTOU HOJE");
        }
    }
}
