CREATE DATABASE db_agenda;
USE db_agenda;

CREATE TABLE tb_usuario (
cd_usuario varchar(25),
cd_senha varchar(50),
constraint pk_usuario
  PRIMARY KEY (cd_usuario)
);

CREATE TABLE tb_contato (
nm_contato char(40),
cd_estado int(3),
cd_telefone varchar(11),
ic_tipoTel char(1),
cd_usuario varchar(25),
constraint pk_contato
   PRIMARY KEY (nm_contato),
constraint fk_contato_usuario
	foreign key (cd_usuario) references tb_usuario(cd_usuario)
    on update cascade
    on delete cascade
);

INSERT INTO tb_usuario (cd_usuario, cd_senha) 
VALUES ('Jaaj','35913729pipi');

INSERT INTO tb_contato (nm_contato, cd_estado, cd_telefone, ic_tipoTel, cd_usuario) 
VALUES ('China', 13, '997380606', 'M', 'Jaaj');