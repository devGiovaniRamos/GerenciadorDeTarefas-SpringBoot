package com.todolist.GerenciadorDeTarefas.Config;

import com.todolist.GerenciadorDeTarefas.Exeption.UsuarioSenhaInvalido;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(UsuarioSenhaInvalido.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundExeption(UsuarioSenhaInvalido ex) {
        return ex.getMessage();
    }
}
