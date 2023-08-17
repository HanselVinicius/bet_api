package com.vinicius.br.jogo_do_bixo.models.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    UserDetails findByLogin(String login);


    @Query(""" 
            SELECT a FROM Usuario
            WHERE a.login = :login
           
            """)
    Usuario findUsuarioByLogin(String login);
}
