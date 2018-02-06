drop database if exists fragmentado;

create database fragmentado;

use fragmentado;


create table cliente(
id int primary key auto_increment,
nome varchar(50),
email varchar(50) unique
);

insert into cliente values (1, 'firmino','firmino@gmail.com');
insert into cliente values (2, 'fresno','fresno@gmail.com');
insert into cliente values (3, 'ju','ju@gmail.com');
insert into cliente values (4, 'lu','lu@gmail.com');

select * from cliente;


create table endereco(
idEndereco int primary key auto_increment,
logradouro varchar(50),
bairro varchar(50),
cidade varchar(50),
estado varchar(50),
cep varchar(50),
id_cliente int,
foreign key(id_cliente) references cliente(id)
);


insert into endereco values(null, 'rua das laranjeiras','laranjeiras','rio de janeiro','RJ','22000444',4);
insert into endereco values(null, 'Av Rio Branco 185','centro','rio de janeiro','RJ','22000444',1);
insert into endereco values(null, 'Av Rio Branco 185','centro','rio de janeiro','RJ','22000444',2);
insert into endereco values(null, 'Av Rio Branco 185','centro','rio de janeiro','RJ','22000444',3);

select * from endereco;


create or replace view v$ClienteEndereco as
select id, nome, email, idEndereco, logradouro, bairro, cidade, estado, cep
from cliente c inner join endereco e
where c.id = e.id_cliente;

select * from v$ClienteEndereco;







