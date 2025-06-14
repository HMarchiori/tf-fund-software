-- Inserindo dados na tabela individual
INSERT INTO individual (cpf) VALUES ('12345678900');

-- Inserindo dados na tabela cliente
INSERT INTO cliente (nome, endereco, cpf) 
VALUES ('João Silva', 'Rua Exemplo, 123', '12345678900');

-- Inserindo dados na tabela ejogo
INSERT INTO ejogo (nome, valor_base, plataforma, tipo, dtype) 
VALUES 
    ('Super Aventura', 99.99, 'PlayStation', 'AVENTURA', 'ELETRONICO'),
    ('Fuga Final', 59.99, 'Xbox', 'ESTRATEGIA', 'ELETRONICO'),
    ('Simulador 2025', 129.99, 'PC', 'SIMULACAO', 'ELETRONICO');
