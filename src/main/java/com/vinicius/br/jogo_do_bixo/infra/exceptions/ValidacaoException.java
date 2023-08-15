package com.vinicius.br.jogo_do_bixo.infra.exceptions;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String msg) {
        super(msg);
    }
}
