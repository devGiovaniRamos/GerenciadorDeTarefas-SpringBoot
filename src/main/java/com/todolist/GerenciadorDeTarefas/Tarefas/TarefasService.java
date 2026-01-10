package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TarefasService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void cadastrarTarefa(TarefasModel cadastrar) {
        tarefaRepository.save(cadastrar);
    }

    public List<TarefasModel> listarTarefas() {
        return tarefaRepository.findAll();
    }
}
