package com.acme.adaptadores.controller;

import com.acme.aplicacao.casos.UC_ListaJogos;
import com.acme.aplicacao.casos.UC_ValidaJogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ACMEControllerTest {

    @Mock
    private UC_ValidaJogo validaJogo;

    @Mock
    UC_ListaJogos listaJogos;

    @InjectMocks
    private ACMEController acmeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Métodos para validar o jogo

    @Test
    void validaJogoExistente(){
        Integer codigo = 1;
        assertTrue(Boolean.TRUE.equals(acmeController.validarJogo(codigo).getBody()));

    }

    @Test
    void validaJogoInexistente(){
        Integer codigo = 999;
        assertFalse(Boolean.TRUE.equals(acmeController.validarJogo(codigo).getBody()));

    }
}