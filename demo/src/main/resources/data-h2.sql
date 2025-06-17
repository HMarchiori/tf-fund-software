CREATE TABLE jogo (
                      codigo INT PRIMARY KEY,
                      nome VARCHAR(255),
                      valor_base DECIMAL(10,2),
                      dtype VARCHAR(50),
                      tipo VARCHAR(50),
                      plataforma VARCHAR(50),
                      numero_pecas INT
);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES
    (1, 'The Witcher 3', 100.00, 'eletronico', 'AVENTURA', 'PC', NULL),
    (2, 'Age of Empires IV', 120.00, 'eletronico', 'ESTRATEGIA', 'PC', NULL),
    (3, 'Flight Simulator', 200.00, 'eletronico', 'SIMULACAO', 'PC', NULL),
    (4, 'Overcooked 2', 90.00, 'eletronico', 'ESTRATEGIA', 'Nintendo Switch', NULL);

-- Jogos de mesa
INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES
    (5, 'UNO Deluxe', 40.00, 'mesa', 'CARTA', NULL, NULL),
    (6, 'Banco de Especulação Imobiliária', 150.00, 'mesa', 'TABULEIRO', NULL, 150),
    (7, 'Xadrez Clássico', 80.00, 'mesa', 'TABULEIRO', NULL, 32),
    (8, 'Jogo da Vida', 60.00, 'mesa', 'TABULEIRO', NULL, 80);