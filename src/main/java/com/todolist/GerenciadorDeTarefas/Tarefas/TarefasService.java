package com.todolist.GerenciadorDeTarefas.Tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefasService {

    @Autowired
    private final TarefaRepository tarefaRepository;
    private final TarefasMapper tarefasMapper;

    public TarefasService(TarefaRepository tarefaRepository, TarefasMapper tarefasMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefasMapper = tarefasMapper;
    }

    public TarefasDTO cadastrarTarefa(TarefasDTO cadastrar) {
        TarefasModel tarefasModel = tarefasMapper.map(cadastrar);
        tarefasModel = tarefaRepository.save(tarefasModel);
        return tarefasMapper.map(tarefasModel);
    }

    public List<TarefasDTO> listarTarefas() {
        List<TarefasModel> tarefas = tarefaRepository.findAll();
        return tarefas.stream().map(tarefasMapper::map).collect(Collectors.toList());
    }

    //Atualizar tarefa
    public TarefasDTO atualizarTarefa(Long id, TarefasDTO novaTarefa) {
        TarefasModel tarefaEntity = tarefaRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Tarefa não encontrado"));
        TarefasModel tarefaAtualizada = TarefasModel.builder()
                .id(tarefaEntity.getId())
                .nome(novaTarefa.getNome() != null ?
                        novaTarefa.getNome() : tarefaEntity.getNome())
                .descricao(novaTarefa.getDescricao() != null ?
                        novaTarefa.getDescricao() : tarefaEntity.getDescricao())
                .data(tarefaEntity.getData())
                .concluida(novaTarefa.isConcluida())
                .build();
        TarefasModel salvo =  tarefaRepository.save(tarefaAtualizada);
        return tarefasMapper.map(salvo);
    }

    public void deletarTarefa(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException( "Id não encontrado");
        }
        tarefaRepository.deleteById(id);
    }
}



