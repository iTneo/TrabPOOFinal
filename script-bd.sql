create database if not exists agenda;
use agenda;
create table if not exists contatos (
  idCod int auto_increment primary key,
  Nome varchar(200),
  Mail varchar(100),
  Telefone varchar(30)
);
