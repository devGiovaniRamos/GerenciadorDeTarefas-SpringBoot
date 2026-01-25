package com.todolist.GerenciadorDeTarefas.Usuario;
import com.todolist.GerenciadorDeTarefas.Tarefas.TarefasModel;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TarefasModel> tarefas;

}
