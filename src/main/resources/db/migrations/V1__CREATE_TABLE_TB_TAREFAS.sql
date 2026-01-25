CREATE TABLE tb_tarefas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_tarefa VARCHAR(255) NOT NULL,
    descricao_tarefa VARCHAR(255),
    data_inicio DATE,
    tarefa_concluida BOOLEAN
);