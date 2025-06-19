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
                         numero INTEGER PRIMARY KEY,
                         nome VARCHAR(255),
                         endereco VARCHAR(255),
                         tipo_cliente VARCHAR(20) NOT NULL,
                         cpf VARCHAR(14),
                         cnpj VARCHAR(18),
                         nome_fantasia VARCHAR(255)
);