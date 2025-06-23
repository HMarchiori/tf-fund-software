package com.acme;
import com.acme.adaptadores.controller.cadastro.CadastroController;
import com.acme.adaptadores.dto.jogo.JogoEletronicoDTO;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import com.acme.adaptadores.dto.cliente.ClienteIndividualDTO;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.frameworks.impl.JogoJpaImpl;
import com.acme.frameworks.impl.ClienteJpaImpl;
import com.acme.frameworks.impl.AluguelJpaImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CadastroControllerTest {

    @Autowired
    private CadastroController controller;

    @Autowired
    private JogoJpaImpl jogoRepo;

    @Autowired
    private ClienteJpaImpl clienteRepo;

    @Autowired
    private AluguelJpaImpl aluguelRepo;

    @SuppressWarnings("deprecation")
    @Test
    void deveCadastrarJogo() {
        JogoEletronicoDTO jogo = new JogoEletronicoDTO();
        jogo.setCodigo(1);
        jogo.setNome("The Sims");
        jogo.setPlataforma("PC");
        jogo.setTipo(TipoEletronico.AVENTURA);
        jogo.setValorBase(120.0);

        ResponseEntity<Void> response = controller.cadastrarJogo(jogo);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(jogoRepo.getJogoPorId(1));
    }

    @SuppressWarnings("deprecation")
    @Test
    void deveCadastrarCliente() {
        ClienteIndividualDTO cliente = new ClienteIndividualDTO();
        cliente.setNumero(1);
        cliente.setNome("João da Silva");
        cliente.setCpf("12345678900");

        ResponseEntity<Void> response = controller.cadastrarCliente(cliente);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(clienteRepo.getClienteByNumero(1));
    }

    @SuppressWarnings("deprecation")
    @Test
    void deveCadastrarAluguel() {
        // Cadastro prévio de jogo
        JogoEletronicoDTO jogo = new JogoEletronicoDTO();
        jogo.setCodigo(2);
        jogo.setNome("FIFA 23");
        jogo.setPlataforma("PS5");
        jogo.setTipo(TipoEletronico.AVENTURA);
        jogo.setValorBase(150.0);
        controller.cadastrarJogo(jogo);

        // Cadastro prévio de cliente
        ClienteIndividualDTO cliente = new ClienteIndividualDTO();
        cliente.setNumero(2);
        cliente.setNome("Maria");
        cliente.setCpf("98765432100");
        controller.cadastrarCliente(cliente);

        // Aluguel com jogo + cliente válidos
        AluguelDTO aluguel = new AluguelDTO();
        aluguel.setIdentificador(10);
        aluguel.setCodigo(2);
        aluguel.setNumero(2);
        aluguel.setDataInicial(new Date());
        aluguel.setPeriodo(7);

        ResponseEntity<Void> response = controller.cadastrarAluguel(aluguel);
        assertEquals(200, response.getStatusCodeValue());
         assertNotNull(aluguelRepo.getAluguelByIdentificador(10));
    }
}
