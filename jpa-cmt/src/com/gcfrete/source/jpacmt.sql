CREATE DATABASE  IF NOT EXISTS jpacmt;
USE jpacmt;

DROP TABLE IF EXISTS usuario;

CREATE TABLE usuario (
  id int(11) NOT NULL,
  email varchar(255) DEFAULT NULL,
  login varchar(255) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL,
  data_de_cadastro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  status int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

