package com.acme.aplicacao.unitarios.validacao;

import com.acme.aplicacao.casos.validacao.UC_ValidaJogo;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ValidaJogoTest {

    private final IJogoRepositorio repositorio = Mockito.mock(IJogoRepositorio.class);
    private final UC_ValidaJogo service = new UC_ValidaJogo(repositorio);

    @Test
    void validaJogoExistente() {
        Mockito.when(repositorio.existeJogoPorId(1)).thenReturn(true);
        assertTrue(service.executarUC(1));
    }

    @Test
    void validaJogoInexistente() {
        Mockito.when(repositorio.existeJogoPorId(2)).thenReturn(false);
        assertFalse(service.executarUC(2));
    }
}