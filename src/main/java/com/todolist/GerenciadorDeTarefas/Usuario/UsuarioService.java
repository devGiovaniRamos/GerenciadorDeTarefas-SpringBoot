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
}
