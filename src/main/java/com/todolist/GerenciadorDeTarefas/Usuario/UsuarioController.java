package com.todolist.GerenciadorDeTarefas.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {
        UsuarioDTO atualizarUsuario = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok("Usuario atualizado com sucesso");
    }
}
