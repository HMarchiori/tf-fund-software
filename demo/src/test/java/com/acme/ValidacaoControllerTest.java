package com.acme;

//package com.acme.adaptadores.controller;

import com.acme.adaptadores.controller.validacao.ValidacaoController;
import com.acme.adaptadores.dto.validate.ValidateAluguelDTO;
import com.acme.adaptadores.dto.validate.ValidateClienteDTO;
import com.acme.adaptadores.dto.validate.ValidateJogoDTO;
import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.frameworks.entity.aluguel.EAluguel;
import com.acme.frameworks.entity.cliente.EIndividual;
import com.acme.frameworks.entity.jogo.EJogoEletronico;
import com.acme.frameworks.impl.AluguelJpaImpl;
import com.acme.frameworks.impl.ClienteJpaImpl;
import com.acme.frameworks.impl.JogoJpaImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;



import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidacaoControllerTest {

    @Autowired
    private ValidacaoController controller;

    @Autowired
    private JogoJpaImpl jogoRepository;

    @Autowired
    private ClienteJpaImpl clienteRepository;

    @Autowired
    private AluguelJpaImpl aluguelRepository;

    @BeforeEach
    void setUp() {
        EJogoEletronico jogo = new EJogoEletronico();
        jogo.setCodigo(1);
        jogo.setNome("FIFA 23");
        jogo.setValorBase(120.0);
        jogo.setTipo(TipoEletronico.AVENTURA);
        jogo.setPlataforma("PS5");
        jogoRepository.salvarJogo(JogoMapper.toDomain(jogo));

        EIndividual cliente = new EIndividual();
        cliente.setNumero(10);
        cliente.setNome("Carlos");
        cliente.setCpf("12345678900");
        clienteRepository.salvarCliente(ClienteMapper.toDomain(cliente));

        EAluguel aluguel = new EAluguel();
      aluguel.setIdentificador(100);
      aluguel.setCliente(cliente); // ECliente que você deve ter criado antes
      aluguel.setJogo(jogo);       // EJogo que você deve ter criado antes
      aluguel.setDataInicial(new Date());
      aluguel.setPeriodo(5); // 5 dias de aluguel
      aluguelRepository.salvarAluguel(AluguelMapper.toDomain(aluguel));
    }

    @Test
    void validarJogoExistente() {
        var request = new ValidateJogoDTO(1);
        ResponseEntity<Boolean> response = controller.validarJogo(request);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validarJogoInexistente() {
        var request = new ValidateJogoDTO(999);
        ResponseEntity<Boolean> response = controller.validarJogo(request);
        assertEquals(Boolean.FALSE, response.getBody());
    }

    @Test
    void validarClienteExistente() {
        var request = new ValidateClienteDTO(10);
        ResponseEntity<Boolean> response = controller.validarCliente(request);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validarClienteInexistente() {
        var request = new ValidateClienteDTO(999);
        ResponseEntity<Boolean> response = controller.validarCliente(request);
        assertEquals(Boolean.FALSE, response.getBody());
    }

    @Test
    void validarAluguelExistente() {
        var request = new ValidateAluguelDTO(100);
        ResponseEntity<Boolean> response = controller.validarAluguel(request);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validarAluguelInexistente() {
        var request = new ValidateAluguelDTO(999);
        ResponseEntity<Boolean> response = controller.validarAluguel(request);
        assertEquals(Boolean.FALSE, response.getBody());
    }
}
