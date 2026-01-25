package com.todolist.GerenciadorDeTarefas.Usuario;
import com.todolist.GerenciadorDeTarefas.Tarefas.TarefasModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String senha;
    private List<TarefasModel> tarefas;

    public UsuarioDTO(String nome, String senha, List<TarefasModel> tarefas) {
        this.nome = nome;
        this.senha = senha;
        this.tarefas = tarefas;
    }
}
