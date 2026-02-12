package com.todolist.GerenciadorDeTarefas.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository tarefaRepository, UsuarioMapper tarefasMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = tarefaRepository;
        this.usuarioMapper = tarefasMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO cadastrar) {
        UsuarioModel usuarioModel = usuarioMapper.map(cadastrar);
        String senhaCriptografada = passwordEncoder.encode(usuarioModel.getSenha());
        usuarioModel.setSenha(senhaCriptografada);
        usuarioModel = usuarioRepository.save(usuarioModel);
        return usuarioMapper.map(usuarioModel);
    }

//    public UsuarioDTO logarUsuario(UsuarioDTO usuario) {
//        UsuarioModel usuarioModel = usuarioMapper.map(usuario);
//        usuarioModel = usuarioRepository.findByNome(usuario.getNome()).orElseThrow(() -> new RuntimeException(
//                "Usuário não encontrado"));
//        if (passwordEncoder.matches(usuario.getSenha(), usuarioModel.getSenha())) {
//            return usuarioMapper.map(usuarioModel);
//        }
//        else {
//            throw new RuntimeException("Senha inválida");
//        }
//    }

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByNome(username).orElseThrow(() -> new UsernameNotFoundException("Usuário ou senha inválido"));
    }
}
