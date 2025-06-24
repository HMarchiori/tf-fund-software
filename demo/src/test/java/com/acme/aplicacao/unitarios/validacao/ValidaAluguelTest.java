package com.acme.aplicacao.unitarios.validacao;

import com.acme.aplicacao.casos.validacao.UC_ValidaAluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ValidaAluguelTest {

    private final IAluguelRepositorio repositorio = Mockito.mock(IAluguelRepositorio.class);
    private final UC_ValidaAluguel service = new UC_ValidaAluguel(repositorio);

    @Test
    void validaAluguelExistente() {
        Mockito.when(repositorio.existeAluguelPorIdentificador(1)).thenReturn(true);
        assertTrue(service.executarUC(1));
    }

    @Test
    void validaAluguelInexistente() {
        Mockito.when(repositorio.existeAluguelPorIdentificador(2)).thenReturn(false);
        assertFalse(service.executarUC(2));
    }
}