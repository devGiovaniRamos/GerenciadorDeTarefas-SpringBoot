package com.todolist.GerenciadorDeTarefas.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.todolist.GerenciadorDeTarefas.Usuario.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    @Value("${SECRET}")
    private String secret;

    public String geradorToken(UsuarioModel usuarioModel) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(usuarioModel.getNome())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .sign(algorithm);
    }
}
