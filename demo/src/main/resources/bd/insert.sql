-- Jogos eletrônicos
INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (1, 'The Witcher 3', 100.00, 'eletronico', 'AVENTURA', 'PC', NULL);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (2, 'Age of Empires IV', 120.00, 'eletronico', 'ESTRATEGIA', 'PC', NULL);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (3, 'Flight Simulator', 200.00, 'eletronico', 'SIMULACAO', 'PC', NULL);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (4, 'Overcooked 2', 90.00, 'eletronico', 'ESTRATEGIA', 'Nintendo Switch', NULL);

-- Jogos de mesa
INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (5, 'UNO Deluxe', 40.00, 'mesa', 'CARTAS', NULL, NULL);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (6, 'Banco de Especulação Imobiliária', 150.00, 'mesa', 'TABULEIRO', NULL, 150);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (7, 'Xadrez Clássico', 80.00, 'mesa', 'TABULEIRO', NULL, 32);

INSERT INTO jogo (codigo, nome, valor_base, dtype, tipo, plataforma, numero_pecas)
VALUES (8, 'Jogo da Vida', 60.00, 'mesa', 'TABULEIRO', NULL, 80);



INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cpf)
VALUES (1, 'Emily Thompson', '123 Ocean Drive, Miami, FL', 'individual', '111.222.333-44');

INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cpf)
VALUES (2, 'Alexander Cooper', '456 Park Avenue, New York, NY', 'individual', '555.666.777-88');

INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cpf)
VALUES (3, 'Isabella Moreau', '789 Sunset Blvd, Los Angeles, CA', 'individual', '999.000.111-22');

INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cnpj, nome_fantasia)
VALUES (4, 'Aurora Tech Inc.', '10 Silicon Valley Rd, Palo Alto, CA', 'empresarial', '12.345.678/0001-99', 'Aurora Innovations');

INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cnpj, nome_fantasia)
VALUES (5, 'Velvet Events Ltd.', '99 Queen Street, Toronto, ON', 'empresarial', '98.765.432/0001-11', 'Velvet Weddings');

INSERT INTO cliente (numero, nome, endereco, tipo_cliente, cnpj, nome_fantasia)
VALUES (6, 'Stellar Media Group', '500 Oxford Street, London, UK', 'empresarial', '66.777.888/0001-55', 'Stellar Entertainment');

INSERT INTO aluguel (identificador, data_inicial, periodo, jogo_codigo, cliente_numero)
VALUES (1, '2023-01-01', 5, 1, 1);

INSERT INTO aluguel (identificador, data_inicial, periodo, jogo_codigo, cliente_numero)
VALUES (2, '2023-01-10', 10, 2, 4);