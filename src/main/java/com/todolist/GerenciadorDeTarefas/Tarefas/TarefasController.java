package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefa")
public class TarefasController {

    //ROTAS...

    //Cadastrar tarefa
    @GetMapping("/cadastrar")
    public String helloword() {
        return "HelloWord!";
    }

    //Ver tarefas

    //Atualizar tarefa

    //Deletar tarefa

}
