create table self_storage.clientes(
	id integer not null auto_increment,
	name varchar(255) not null,
	email varchar(255) not null,
	senha varchar(255) not null,
	primary key(id)
);

create table self_storage.armazenamentos(
	id integer not null auto_increment,
	categoria varchar(255) not null,
	endereco varchar(255) not null,
	volume varchar(255) not null,
	custo float not null,
	primary key(id)
);

create table self_storage.aluguel(
	id integer not null auto_increment,
	dataInicio date not null,
	dataFim date not null,
	seguro int not null,
	chaveExtra int not null,
	controleClimatico int not null,
	clienteId int not null,
	armazenamentoId int not null,
	primary key(id),
	foreign key (clienteId) references clientes(id),
	foreign key (armazenamentoId) references armazenamentos(id)
);
