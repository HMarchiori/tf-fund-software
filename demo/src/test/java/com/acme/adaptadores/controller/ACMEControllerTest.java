package com.acme.adaptadores.controller;

import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.frameworks.JogoJpaImpl;
import com.acme.frameworks.entity.EJogoEletronico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ACMEControllerTest {

    @Autowired
    private ACMEController acmeController;



    @Autowired
    private JogoJpaImpl repositorio;

    @BeforeEach
    void setUp() {
        EJogoEletronico ejogo = new EJogoEletronico();
        ejogo.setCodigo(1);
        ejogo.setNome("The Sims 4");
        ejogo.setValorBase(100.0);
        ejogo.setTipo(TipoEletronico.SIMULACAO);
        ejogo.setPlataforma("PC");

        var jogo = JogoMapper.toDomain(ejogo);
        repositorio.salvarJogo(jogo);
    }

    @Test
    void validaJogoExistente() {
        Integer codigo = 1;
        ResponseEntity<Boolean> response = acmeController.validarJogo(codigo);
        assertEquals(Boolean.TRUE, response.getBody());
    }

    @Test
    void validaJogoInexistente() {
        Integer codigo = 999;
        ResponseEntity<Boolean> response = acmeController.validarJogo(codigo);
        assertEquals(Boolean.FALSE, response.getBody());
    }
}