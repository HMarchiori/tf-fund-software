package com.acme.adaptadores.integracao;

import com.acme.adaptadores.controller.cadastro.CadastroController;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.dto.cliente.ClienteIndividualDTO;
import com.acme.adaptadores.dto.jogo.JogoEletronicoDTO;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.frameworks.impl.AluguelJpaImpl;
import com.acme.frameworks.impl.ClienteJpaImpl;
import com.acme.frameworks.impl.JogoJpaImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CadastroControllerTest {

    @Autowired
    private CadastroController controller;
    @Autowired
    private JogoJpaImpl jogoRepository;
    @Autowired
    private ClienteJpaImpl clienteRepository;
    @Autowired
    private AluguelJpaImpl aluguelRepository;

    @Test
    void cadastraNovoJogo() {
        JogoEletronicoDTO dto = new JogoEletronicoDTO(99, "Game Test", 50.0, TipoEletronico.AVENTURA, "PC");
        ResponseEntity<Void> response = controller.cadastrarJogo(dto);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(jogoRepository.getJogoPorId(99));
    }

    @Test
    void cadastraNovoCliente() {
        ClienteIndividualDTO dto = new ClienteIndividualDTO(99, "Cliente Test", "Endereco", "000.000.000-00");
        ResponseEntity<Void> response = controller.cadastrarCliente(dto);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(clienteRepository.getClienteByNumero(99));
    }

    @Test
    void cadastraNovoAluguel() {
        JogoEletronico jogo = new JogoEletronico(98, "Temp", 40.0, TipoEletronico.AVENTURA, "PC");
        jogoRepository.salvarJogo(jogo);
        ClienteIndividual cliente = new ClienteIndividual(98, "Temp", "Endereco", "111.111.111-11");
        clienteRepository.salvarCliente(cliente);

        AluguelDTO dto = new AluguelDTO(77, new Date(), 5, JogoMapper.toDTO(jogo), ClienteMapper.toDTO(cliente));
        ResponseEntity<Void> response = controller.cadastrarAluguel(dto);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(aluguelRepository.getAluguelByIdentificador(77));
    }
}