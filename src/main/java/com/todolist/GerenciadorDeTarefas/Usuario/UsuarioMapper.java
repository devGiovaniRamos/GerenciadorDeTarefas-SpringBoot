package com.todolist.GerenciadorDeTarefas.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioDTO.getNome());
        usuarioModel.setSenha(usuarioDTO.getSenha());

        return usuarioModel;
    }

    public  UsuarioDTO map(UsuarioModel usuarioModel) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(usuarioModel.getNome());
        usuarioDTO.setSenha(usuarioModel.getSenha());

        return usuarioDTO;
    }


}
