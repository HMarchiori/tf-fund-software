Trabalho final da diciplina de fundamentos de desenvolvimento de software


LISTA DE TAREFAS:

* Criação de Relatório com
1. o Diagrama de classes que apresente a arquitetura do sistema. <PIETRO>
2. o Padrões utilizados no sistema. <HENRIQUE>
3. o URL do repositório Git. <HENRIQUE>
* Cuidar da lógica de entidades + persistência. <BRYAN E PIETRO>
* Cuidar dos Serviços <BRYAN>
* Criar endpoints <TODOS>
* Testes Unitários <HENRIQUE>
* Testes de Endpoints <HENRIQUE>
* PONTO EXTRA: FRONT <BRYAN>

LISTA DE ENDPOINTS:
1. Endpoint: POST /acmegames/validajogo
   <HENRIQUE>

2. Endpoint: POST /acmegames/validacliente

3. Endpoint: POST /acmegames/validaaluguel

4. Endpoint: GET /acmegames/cadastro/listajogos

5. Endpoint: GET /acmegames/cadastro/listaclientes

6. Endpoint: GET /acmegames/cadastro/listaalugueis

7. Endpoint: POST /acmegames/cadastro/cadjogo
--Como passar os parâmetros para o Endpoint--
{
  "tipoJogo": "eletronico",
  "nome": "Super Mario Bros",
  "valorBase": 150.00,
  "tipo": "AVENTURA",
  "plataforma": "Nintendo Switch"
}



8. Endpoint: POST /acmegames/cadastro/cadcliente
--Como passar os parâmetros para o Endpoint--
{
    "nome": "Bryan",
    "endereco": "rua das adalias, 549",
    "individual": {
        "cpf": "60105238007"
    }
}

---------------CNPJ-----------------------
{
    "nome": "Bryan",
    "endereco": "rua das adalias, 549",
    "empresarial": {
        "cnpj": "20105238000107"
    }
}



9. Endpoint: POST /acmegames/cadastro/cadaluguel
   --Como passar os parâmetros para o Endpoint--
   {
    "periodo" : 10,
    "cliente" : {
        "id" : 1
    },
    "jogo":{
        "tipoJogo" : "eletronico",
        "codigo": 1
    }
}

10. Endpoint: GET /acmegames/cliente/aluguel/:numero

11. Endpoint: GET /acmegames/jogo/aluguel/:codigo

12. Endpoint: GET /acmegames/aluguel/valorjogo/:codigo

13. Endpoint: GET /acmegames/aluguel/valorfinal/:identificador