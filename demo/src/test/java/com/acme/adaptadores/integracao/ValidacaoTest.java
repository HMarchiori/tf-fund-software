package com.acme.adaptadores.integracao;

import com.acme.adaptadores.controller.validacao.ValidacaoController;
import com.acme.adaptadores.dto.validate.ValidateAluguelDTO;
import com.acme.adaptadores.dto.validate.ValidateClienteDTO;
import com.acme.adaptadores.dto.validate.ValidateJogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.frameworks.entity.jogo.EJogoEletronico;
import com.acme.frameworks.impl.JogoJpaImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidacaoTest {

    @Autowired
    private ValidacaoController controller;

    @Autowired
    private JogoJpaImpl repository;

    @BeforeEach
    void setUp() {
        EJogoEletronico ejogo = new EJogoEletronico();
        ejogo.setCodigo(1);
        ejogo.setNome("The Sims 4");
        ejogo.setValorBase(100.0);
        ejogo.setTipo(TipoEletronico.SIMULACAO);
        ejogo.setPlataforma("PC");

        var jogo = JogoMapper.toDomain(ejogo);
        repository.salvarJogo(jogo);
    }

    @Test
    void validaJogoExistente() {
        ValidateJogoDTO codigo = new ValidateJogoDTO(1);
        ResponseEntity<Boolean> response = controller.validarJogo(codigo);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validaJogoInexistente() {
        ValidateJogoDTO codigo = new ValidateJogoDTO(999);
        ResponseEntity<Boolean> response = controller.validarJogo(codigo);
        assertEquals(Boolean.FALSE, response.getBody());
    }

    @Test
    void validaClienteExistente() {
        ValidateClienteDTO dto = new ValidateClienteDTO(1);
        ResponseEntity<Boolean> response = controller.validarCliente(dto);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validaClienteInexistente() {
        ValidateClienteDTO dto = new ValidateClienteDTO(999);
        ResponseEntity<Boolean> response = controller.validarCliente(dto);
        assertEquals(Boolean.FALSE, response.getBody());
    }

    @Test
    void validaAluguelExistente() {
        ValidateAluguelDTO dto = new ValidateAluguelDTO(1);
        ResponseEntity<Boolean> response = controller.validarAluguel(dto);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validaAluguelInexistente() {
        ValidateAluguelDTO dto = new ValidateAluguelDTO(999);
        ResponseEntity<Boolean> response = controller.validarAluguel(dto);
        assertEquals(Boolean.FALSE, response.getBody());
    }

}