create database Projeto_Final ;
use Projeto_Final;

create table Administrador(
	id int not null primary key,
	login varchar(255),
    senha varchar(255),
    nome varchar(255),
    cpf varchar(11)
);

create table eleitor(
	id int not null primary key,
    nome varchar(255),
    cpf varchar(11) unique,
	tituloEleitoral varchar(255),
    zona varchar(255),
    secao varchar(255),
    jaVotou boolean not null default false
);



create table partido(
	id int not null primary key,
    numeroPartido varchar(255),
    sigla varchar(255),
    nomePartido varchar(255)
);

create table cargo(
	id int not null primary key,
	nome varchar(255),
    quantidadeDigitos int not null,
    descricao varchar(1000)
    
);
create table Candidato(
	id int not null primary key,
    nome varchar(255),
    cpf varchar(11) unique,
    numero int not null,
	foto LONGBLOB,
    votos int default 0,
    idPartido int not null,
    numeroPartido int not null,
    sigla varchar(255),
    nomePartido varchar(255),
	idCargo int not null,
    nomeCargo varchar(255),
    quantidadeDigitos int not null,
    descricao varchar(1000),
    foreign key (idPartido) REFERENCES partido(id),
    foreign key (idCargo) References cargo(id)
    
);
create table voto(
	id int not null primary key,
    idCandidato int not null,
    nomeCandidato varchar(255) not null,
	cpfCandidato varchar(11),
    numeroCandidato int not null,
    fotoCandidato LONGBLOB,
    idPartido int not null,
    numeroPartido int not null,
    sigla varchar(255),
    nomePartido varchar(255),
	idCargo int not null,
    nomeCargo varchar(255),
    quantidadeDigitos int not null,
    descricao varchar(1000),
    tipoVoto enum("VALIDO","BRANCO","NULO"),
    dataHora datetime default current_timestamp,
    foreign key (idPartido) references partido(id),
    foreign key (idCargo) references cargo(id),
    foreign key (idCandidato) references Candidato(id)
);