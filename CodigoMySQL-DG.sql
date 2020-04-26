drop database dbdarkglory;
CREATE DATABASE dbDarkGlory;
use dbDarkGlory;

CREATE TABLE player (
	id int auto_increment not null,
	nome varchar(30) not null,
    mana int,
    wins int,
    vez int,
    primary key (id)
);

CREATE TABLE lutadores (
	id int auto_increment not null,
    nome varchar(30) not null,
    dano int,
    vida int,
    vez int,
    barreira int,
    dono varchar(30),
    PRIMARY KEY (id)
);

