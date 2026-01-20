package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody TarefasDTO tarefasModel) {
        TarefasDTO novaTarefa = tarefasService.cadastrarTarefa(tarefasModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa " + novaTarefa.getNome() +
                " criada com sucesso.");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefasDTO>> listar() {
         List<TarefasDTO> tarefas = tarefasService.listarTarefas();
         return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTarefa(@PathVariable Long id, @RequestBody TarefasDTO tarefaAtualizada) {
        TarefasDTO novaTarefa = tarefasService.atualizarTarefa(id, tarefaAtualizada);
        return ResponseEntity.ok("Tarefa " +novaTarefa.getNome() + " atualizada com sucesso!");
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable Long id) {
        tarefasService.deletarTarefa(id);
        return ResponseEntity.ok("Tarefa deletada");
    }
}
