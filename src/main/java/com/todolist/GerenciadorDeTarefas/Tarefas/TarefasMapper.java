package com.todolist.GerenciadorDeTarefas.Tarefas;
import org.springframework.stereotype.Component;

@Component
public class TarefasMapper {

    public TarefasModel map(TarefasDTO tarefasDTO) {

        TarefasModel tarefasModel = new TarefasModel();
        tarefasModel.setId(tarefasDTO.getId());
        tarefasModel.setNome(tarefasDTO.getNome());
        tarefasModel.setDescricao(tarefasDTO.getDescricao());
        tarefasModel.setData(tarefasDTO.getData());
        tarefasModel.setConcluida(tarefasDTO.isConcluida());
        tarefasModel.setUsuario(tarefasDTO.getUsuario());

        return tarefasModel;
    }

    public  TarefasDTO map(TarefasModel tarefasModel) {

        TarefasDTO tarefasDTO = new TarefasDTO();
        tarefasDTO.setId(tarefasModel.getId());
        tarefasDTO.setNome(tarefasModel.getNome());
        tarefasDTO.setDescricao(tarefasModel.getDescricao());
        tarefasDTO.setData(tarefasModel.getData());
        tarefasDTO.setConcluida(tarefasModel.isConcluida());
        tarefasDTO.setUsuario(tarefasModel.getUsuario());

        return tarefasDTO;
    }
}
