CREATE TABLE jogo (
                      codigo INTEGER PRIMARY KEY,
                      nome VARCHAR(255),
                      valor_base DOUBLE,
                      dtype VARCHAR(31) NOT NULL,
                      tipo VARCHAR(255),
                      plataforma VARCHAR(255),
                      numero_pecas INTEGER
);