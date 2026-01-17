package com.todolist.GerenciadorDeTarefas.Tarefas;

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

    public TarefasDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.concluida = false;
    }
}
