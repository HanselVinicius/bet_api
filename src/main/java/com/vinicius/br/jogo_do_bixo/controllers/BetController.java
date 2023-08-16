package com.vinicius.br.jogo_do_bixo.controllers;

import com.vinicius.br.jogo_do_bixo.models.bet.Bet;
import com.vinicius.br.jogo_do_bixo.models.bet.BetService;
import com.vinicius.br.jogo_do_bixo.models.bet.BetRegisterDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/bet")
@SecurityRequirement(name = "bearer-key")
public class BetController {

    @Autowired
    private BetService betService;



    @PostMapping("/register")
    public ResponseEntity registerBet(@RequestBody BetRegisterDTO dto){
        Bet bet = betService.createBet(dto);
        return ResponseEntity.ok().build();
    }
}
