CREATE DATABASE IF NOT EXISTS pgbd;
USE pgbd;

DROP TABLE IF EXISTS palestra;
DROP TABLE IF EXISTS palestrante;
DROP TABLE IF EXISTS sala;
DROP TABLE IF EXISTS evento;
DROP TABLE IF EXISTS predio;

CREATE TABLE IF NOT EXISTS predio (
    id_predio            INTEGER          AUTO_INCREMENT,
    nome_predio          VARCHAR(50)      NOT NULL,
    PRIMARY KEY          (id_predio)
);

CREATE TABLE IF NOT EXISTS sala (
    id_sala              INTEGER          AUTO_INCREMENT,
    id_predio            INTEGER          NOT NULL,
    nome_sala            VARCHAR(50)      NOT NULL,
    capacidade           INTEGER          NULL,
    PRIMARY KEY          (id_sala),
    FOREIGN KEY          (id_predio)      REFERENCES predio (id_predio)
);

CREATE TABLE IF NOT EXISTS evento (
    id_evento            INTEGER          AUTO_INCREMENT,
    id_predio            INTEGER          NULL,
    nome_evento          VARCHAR(255)     NOT NULL,
    descricao_evento     VARCHAR(255)     NULL,
    endereco             VARCHAR(255)     NOT NULL,
    data_inicio          DATE             NOT NULL,
    data_fim             DATE             NOT NULL,
    PRIMARY KEY          (id_evento),
    FOREIGN KEY          (id_predio)      REFERENCES predio (id_predio)
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
    id_sala              INTEGER          NOT NULL,
    titulo               VARCHAR(255)     NOT NULL,
    assunto_area         VARCHAR(255)     NOT NULL,
    descricao_palestra   VARCHAR(255)     NULL,
    data_inicio          DATETIME         NOT NULL,
    data_fim             DATETIME         NOT NULL,
    PRIMARY KEY          (id_palestra),
    FOREIGN KEY          (id_palestrante) REFERENCES palestrante (id_palestrante),
    FOREIGN KEY          (id_evento)      REFERENCES evento      (id_evento),
    FOREIGN KEY          (id_sala)        REFERENCES sala        (id_sala)
);
