use db_agenda_contatos;

-- CRUD CREATE
create table contatos
(
	id_contatos int not null auto_increment primary key,
    nome varchar(100) not null,
    fone varchar(20) not null,
    email varchar(100)
);

-- CRUD READ
select * from contatos;