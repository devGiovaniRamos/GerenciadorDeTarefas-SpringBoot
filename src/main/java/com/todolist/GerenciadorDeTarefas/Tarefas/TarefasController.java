package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;

    //ROTAS...

    //Cadastrar tarefa
    @PostMapping("/cadastrar")
    public TarefasModel cadastrar(@RequestBody TarefasModel tarefasModel) {
        return tarefasService.cadastrarTarefa(tarefasModel);
    }

    //Ver tarefas
    @GetMapping("/listar")
    public List<TarefasModel> listar() {
        return tarefasService.listarTarefas();
    }

    //Atualizar tarefa

    //Deletar tarefa
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefasService.deletarTarefa(id);
    }

}
