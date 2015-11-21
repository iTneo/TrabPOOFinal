create database if not exists agenda;
use agenda;
create table if not exists contatos (
  idCod int auto_increment primary key,
  Nome varchar(200),
  Telefone varchar(30),
  Mail varchar(100)
);
insert into contatos (Nome, Telefone, Mail) values
    ('Jonathan', '47 9999-9999', 'jonathan@teste.com.br'),
    ('Mateus', '47 8888-8888', 'mateus@teste.com.br'),
    ('Henrique', '47 7777-7777', 'henrique@teste.com.br');
