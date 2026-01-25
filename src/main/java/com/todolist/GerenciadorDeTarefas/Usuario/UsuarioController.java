package com.todolist.GerenciadorDeTarefas.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Cadastrar usuario
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuarioDTO = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario " + usuarioDTO.getNome() +
                " cadastrado");
    }

    //Trocar nome e/ou senha de usuario

}
