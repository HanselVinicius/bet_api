package com.vinicius.br.jogo_do_bixo.models.bet.validation;

import com.vinicius.br.jogo_do_bixo.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class AreadyBetTodayValidation implements BetValidator{
    @Override
    public void validate() {

        throw new ValidacaoException("USUARIO INFORMADO JA APOSTOU HOJE");
    }
}
