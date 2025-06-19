package com.acme.adaptadores.controller;

import com.acme.adaptadores.controller.cadastro.ListaController;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import com.acme.frameworks.entity.jogo.EJogoEletronico;
import com.acme.frameworks.entity.jogo.EJogoMesa;
import com.acme.frameworks.impl.JogoJpaImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListaTest {

    @Autowired
    private ListaController listaController;

    @Autowired
    private JogoJpaImpl repository;

    @BeforeEach
    void setUp() {

        // TODO: Implementar o método de limpeza do repositório antes de cada teste
        // coloquei os códigos 9 e 10 para evitar conflitos com os testes de validação
        // TODO: repository.limparRepositório();

        EJogoEletronico jogo1 = new EJogoEletronico();
        // TODO: deve ser 1
        jogo1.setCodigo(9);
        jogo1.setNome("The Sims 4");
        jogo1.setValorBase(100.0);
        jogo1.setTipo(TipoEletronico.SIMULACAO);
        jogo1.setPlataforma("PC");

        EJogoMesa jogo2 = new EJogoMesa();
        // TODO: deve ser 2
        jogo2.setCodigo(10);
        jogo2.setNome("Monopoly");
        jogo2.setValorBase(150.0);
        jogo2.setTipo(TipoMesa.TABULEIRO);
        jogo2.setNumeroPecas(10);

        repository.salvarJogo(JogoMapper.toDomain(jogo1));
        repository.salvarJogo(JogoMapper.toDomain(jogo2));
    }

    @Test
    void deveListarJogosCadastrados() {
        var response = listaController.listarJogos();
        List<JogoDTO> jogos = response.getBody();

        assertNotNull(jogos);
        assertEquals(10, jogos.size());

        var nomes = jogos.stream().map(JogoDTO::getNome).toList();
        assertTrue(nomes.contains("The Sims 4"));
        assertTrue(nomes.contains("Monopoly"));
    }
}