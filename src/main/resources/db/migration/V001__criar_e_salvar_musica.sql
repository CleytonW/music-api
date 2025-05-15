CREATE TABLE music (

    id BIGINT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL,
    artista VARCHAR(20) NOT NULL,
    data_lancamento DATE NOT NULL,
    duracao VARCHAR(20) NOT NULL

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO music (nome, artista, data_lancamento, duracao) VALUES ('SOMEWHERE I BELONG', 'LINKIN PARK', '2003-02-28', '03:33 ')