package com.vinicius.br.jogo_do_bixo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JogoDoBixoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JogoDoBixoApplication.class, args);
	}


}
