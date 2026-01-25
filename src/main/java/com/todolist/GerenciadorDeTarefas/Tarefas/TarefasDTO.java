package com.todolist.GerenciadorDeTarefas.Tarefas;

import com.todolist.GerenciadorDeTarefas.Usuario.UsuarioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TarefasDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private boolean concluida;
    private UsuarioModel usuario;

    public TarefasDTO( String nome, String descricao, UsuarioModel usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
    }
}
