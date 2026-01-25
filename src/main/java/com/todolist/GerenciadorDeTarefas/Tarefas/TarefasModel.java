package com.todolist.GerenciadorDeTarefas.Tarefas;

import com.todolist.GerenciadorDeTarefas.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tarefas")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

}
