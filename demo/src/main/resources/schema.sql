CREATE TABLE jogo (
    codigo INTEGER PRIMARY KEY,
    nome VARCHAR(255),
    valor_base DOUBLE,
    dtype VARCHAR(31) NOT NULL,
    tipo VARCHAR(255),
    plataforma VARCHAR(255),
    numero_pecas INTEGER
);

CREATE TABLE cliente (
    numero INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    tipo_cliente VARCHAR(20) NOT NULL,
    cpf VARCHAR(14),
    cnpj VARCHAR(18),
    nome_fantasia VARCHAR(255)
);

CREATE TABLE aluguel (
    identificador INTEGER PRIMARY KEY AUTO_INCREMENT,
    data_inicial TIMESTAMP NOT NULL,
    periodo INT NOT NULL,
    numero INTEGER, 
    codigo INTEGER, 

    CONSTRAINT fk_aluguel_cliente FOREIGN KEY (numero) REFERENCES cliente(numero),
    CONSTRAINT fk_aluguel_jogo FOREIGN KEY (codigo) REFERENCES jogo(codigo)
);
