package com.todolist.GerenciadorDeTarefas.Tarefas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarefas")
@Getter
@Setter
@NoArgsConstructor
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicio")
    private LocalDate data;

    @Column(name = "concluida")
    private boolean concluida;

    public TarefasModel( String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.concluida = false;
    }
}
