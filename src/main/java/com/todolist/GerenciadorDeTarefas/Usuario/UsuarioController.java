package com.todolist.GerenciadorDeTarefas.Usuario;

import com.todolist.GerenciadorDeTarefas.Config.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    //Cadastrar usuario
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuarioDTO = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario " + usuarioDTO.getNome() +
                " cadastrado");
    }

    //login usuario
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuarioDTO) {
        UsernamePasswordAuthenticationToken acessoUsuario = new UsernamePasswordAuthenticationToken(
                usuarioDTO.getNome(), usuarioDTO.getSenha());
        Authentication authentication = authenticationManager.authenticate(acessoUsuario);

        UsuarioModel usuario = (UsuarioModel) authentication.getPrincipal();

        String token = tokenService.geradorToken(usuario);
    }

    //Trocar nome e/ou senha de usuario
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO novoUsuario) {
        UsuarioDTO atualizarUsuario = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok("Usuario atualizado com sucesso");
    }

}
