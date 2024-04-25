#criar o database chamado db_alunos
create database if not exists db_alunos;

#entrar no database db_alunos
use db_alunos;

#remove a tabela para recriá-la
drop table if exists tb_alunos;

#cria a tabela de tb_alunos
CREATE TABLE tb_alunos ( 
    id      INTEGER NOT NULL, 
    nome    VARCHAR(100), 
    idade   INTEGER,
    curso   VARCHAR(50),
    fase    INTEGER,
    PRIMARY KEY(id)
);

#lista a tabela criada
show tables;
