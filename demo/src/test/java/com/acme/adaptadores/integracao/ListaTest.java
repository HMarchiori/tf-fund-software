package com.acme.adaptadores.integracao;

import com.acme.adaptadores.controller.cadastro.ListaController;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.dto.cliente.ClienteDTO;
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


        EJogoEletronico jogo1 = new EJogoEletronico();
        jogo1.setCodigo(9);
        jogo1.setNome("The Sims 4");
        jogo1.setValorBase(100.0);
        jogo1.setTipo(TipoEletronico.SIMULACAO);
        jogo1.setPlataforma("PC");

        EJogoMesa jogo2 = new EJogoMesa();
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
        // os outros métodos de teste adicionaram mais dois jogos também!!
        assertEquals(12, jogos.size());

        var nomes = jogos.stream().map(JogoDTO::getNome).toList();
        assertTrue(nomes.contains("The Sims 4"));
        assertTrue(nomes.contains("Monopoly"));
    }

    @Test
    void deveListarClientesCadastrados() {
        var response = listaController.listarClientes();
        List<ClienteDTO> clientes = response.getBody();

        assertNotNull(clientes);
        assertTrue(clientes.size() >= 6);

        var nomes = clientes.stream().map(ClienteDTO::getNome).toList();
        assertTrue(nomes.contains("Emily Thompson"));
        assertTrue(nomes.contains("Aurora Tech Inc."));
    }

    @Test
    void deveListarAlugueisCadastrados() {
        var response = listaController.listarAlugueis();
        List<AluguelDTO> alugueis = response.getBody();

        assertNotNull(alugueis);
        assertTrue(alugueis.size() >= 2);

        boolean contains = alugueis.stream().anyMatch(a -> a.getIdentificador() == 1);
        assertTrue(contains);
    }
}