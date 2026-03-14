package com.todolist.GerenciadorDeTarefas.Exeption;

public class UsuarioSenhaInvalido extends RuntimeException{
    public UsuarioSenhaInvalido(String meessage) {
        super(meessage);
    }
}
