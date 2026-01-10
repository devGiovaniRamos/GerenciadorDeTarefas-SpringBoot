package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class TarefasService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public TarefasModel cadastrarTarefa(TarefasModel cadastrar) {
        return tarefaRepository.save(cadastrar);
    }

    public List<TarefasModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    //Atualizar tarefa


    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

}
