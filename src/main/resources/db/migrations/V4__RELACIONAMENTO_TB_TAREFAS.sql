ALTER TABLE tb_tarefas ADD COLUMN IF NOT EXISTS usuario_id BIGINT;
ALTER TABLE tb_tarefas ALTER COLUMN usuario_id SET NOT NULL;
ALTER TABLE tb_tarefas
ADD CONSTRAINT fk_tarefas_usuario
FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id);