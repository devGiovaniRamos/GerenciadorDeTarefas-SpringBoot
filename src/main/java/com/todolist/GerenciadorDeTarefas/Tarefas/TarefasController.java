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
    public TarefasDTO cadastrar(@RequestBody TarefasDTO tarefasModel) {
        return tarefasService.cadastrarTarefa(tarefasModel);
    }

    //Ver tarefas
    @GetMapping("/listar")
    public List<TarefasDTO> listar() {
        return tarefasService.listarTarefas();
    }

    //Atualizar tarefa
    @PutMapping("/atualizar/{id}")
    public void atualizarTarefa(@PathVariable Long id, @RequestBody TarefasDTO tarefaAtualizada) {
        tarefasService.atualizarTarefa(id, tarefaAtualizada);
    }


    //Deletar tarefa
    @DeleteMapping("/deletar/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefasService.deletarTarefa(id);
    }

}
