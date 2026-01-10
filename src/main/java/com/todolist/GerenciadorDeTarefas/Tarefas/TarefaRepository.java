package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefasModel, Long> {
}
