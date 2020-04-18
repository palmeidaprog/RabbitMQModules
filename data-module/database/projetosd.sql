use projetosd;


create table if not exists pessoa(
	id int(7) unsigned not null primary key,
	nome varchar(50) not null,
	sobrenome varchar(50) not null,
	data_nascimento DATE,
	cpf char(11),
	rg varchar(20),
	sexo char(1) not null
);

create table if not exists endereco(
    id int(7) unsigned not null primary key,
    rua varchar(50) not null,
    numero varchar(10) not null ,
    cep int(10) unsigned,
    bairro varchar(35),
    cidade varchar(50) not null,
    estado varchar(35)
);

create table if not exists atendente(
	id int(7) unsigned not null primary key,
	codigo_cracha varchar(35),
	constraint fk_atendente_pessoa foreign key(id) references pessoa(id)
);

create table if not exists paciente(
    id int(7) unsigned not null primary key,
    endereco_id int(7) unsigned not null,
    pcd bit(1) default 0,
    constraint fk_paciente_pessoa foreign key(id) references pessoa(id),
    constraint fk_paciente_endereco foreign key(endereco_id) references endereco(id)
);

create table if not exists agendamento(
    id int(7) unsigned not null primary key,
    paciente_id int(7) unsigned not null,
    data_agendamento date,
    constraint fk_agendamento_paciente foreign key(paciente_id) references paciente(id)
);

create table if not exists atendimento(
    id int(7) unsigned not null primary key,
    agendamento_id  int(7) unsigned not null,
    atendente_id int(7) unsigned not null,
    data_confirmacao  date,
    constraint fk_atendimento_agendamento foreign key(agendamento_id) references agendamento(id),
    constraint fk_atendimento_atendente foreign key(atendente_id) references atendente(id)
);

