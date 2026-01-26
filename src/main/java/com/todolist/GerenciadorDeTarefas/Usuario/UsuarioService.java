package com.todolist.GerenciadorDeTarefas.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository tarefaRepository, UsuarioMapper tarefasMapper) {
        this.usuarioRepository = tarefaRepository;
        this.usuarioMapper = tarefasMapper;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO cadastrar) {
        UsuarioModel usuarioModel = usuarioMapper.map(cadastrar);
        usuarioModel = usuarioRepository.save(usuarioModel);
        return usuarioMapper.map(usuarioModel);
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO novoUsuario) {
        UsuarioModel antigoUusuario = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        UsuarioModel novoUsuarioModel = UsuarioModel.builder()
                .id(antigoUusuario.getId())
                .nome(novoUsuario.getNome() != null ?
                        novoUsuario.getNome() : antigoUusuario.getNome())
                .senha(novoUsuario.getSenha() != null ?
                        novoUsuario.getSenha() : antigoUusuario.getSenha())
                .build();
        UsuarioModel salvo = usuarioRepository.save(novoUsuarioModel);
        return usuarioMapper.map(salvo);
    }
}
