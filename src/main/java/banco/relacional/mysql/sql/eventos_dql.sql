DROP DATABASE IF EXISTS pgbd;
CREATE DATABASE IF NOT EXISTS pgbd;
USE pgbd;

DROP TABLE IF EXISTS palestra;
DROP TABLE IF EXISTS palestrante;
DROP TABLE IF EXISTS evento;

CREATE TABLE IF NOT EXISTS evento (
    id_evento            INTEGER          AUTO_INCREMENT,
    nome_evento          VARCHAR(50)      NOT NULL,
    descricao_evento     VARCHAR(255)     NULL,
    endereco             VARCHAR(255)     NOT NULL,
    predio               VARCHAR(50)      NOT NULL,
    data_inicio          DATE             NOT NULL,
    data_fim             DATE             NOT NULL,
    PRIMARY KEY          (id_evento)
);

CREATE TABLE IF NOT EXISTS palestrante (
    id_palestrante       INTEGER          AUTO_INCREMENT,
    nome_palestrante     VARCHAR(255)     NOT NULL,
    sexo                 CHAR(1)          NOT NULL,
    grau_academico       VARCHAR(255)     NOT NULL,
    nome_curso           VARCHAR(255)     NOT NULL,
    instituicao          VARCHAR(255)     NOT NULL,
    PRIMARY KEY          (id_palestrante)
);

CREATE TABLE IF NOT EXISTS palestra (
    id_palestra          INTEGER          AUTO_INCREMENT,
    id_palestrante       INTEGER          NOT NULL,
    id_evento            INTEGER          NOT NULL,
    titulo               VARCHAR(50)      NOT NULL,
    assunto_area         VARCHAR(255)     NOT NULL,
    descricao_palestra   VARCHAR(255)     NULL,
    sala                 VARCHAR(50)      NOT NULL,
    publico_previsto     INTEGER          NULL,
    data_palestra        DATE             NOT NULL,
    hora_inicio          TIME         	  NOT NULL,
    hora_fim             TIME             NOT NULL,
    PRIMARY KEY          (id_palestra),
    FOREIGN KEY          (id_palestrante) REFERENCES palestrante (id_palestrante),
    FOREIGN KEY          (id_evento)      REFERENCES evento      (id_evento)
);
