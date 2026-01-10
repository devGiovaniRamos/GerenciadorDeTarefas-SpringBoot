package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.stereotype.Service;


@Service
public class TarefasService {

    private TarefaRepository tarefaRepository;

    public void cadastrarTarefa(TarefasModel cadastrar) {
        tarefaRepository.save(cadastrar);
    }
}
