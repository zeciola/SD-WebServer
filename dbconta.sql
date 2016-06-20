-- Database: dbconta

-- DROP DATABASE dbconta;

CREATE DATABASE dbconta
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

create table conta(
	idconta integer not null primary key,
	nome varchar(50) not null,
	saldo numeric
);
alter table conta add column senha varchar(45);

insert into conta values (1, 'Diego', 5000.00);
insert into conta values (2, 'Agnes', 4500.00);

delete from conta where idconta = 4;
update conta set  senha= '123';

select * from conta;
update conta set saldo = saldo - 10 WHERE idconta = 3 and senha = '1234';
CREATE SEQUENCE serial START 1;


create table conta(
	idconta integer not null primary key,
	nome varchar(50) not null,
	saldo numeric
);

CREATE SEQUENCE serial START 1;

insert into conta values (1, 'Kratos', 5000.00);
insert into conta values (2, 'Zeus', 4500.00);

alter table conta add column senha varchar(45);

delete from conta where idconta = 2;

--Senha igual para todos
update conta set  senha= '12345';

select * from conta;

update conta set saldo = saldo - 10 WHERE idconta = 1 and senha = '123' ;
