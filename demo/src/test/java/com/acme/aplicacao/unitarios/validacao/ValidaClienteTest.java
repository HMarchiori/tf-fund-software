package com.acme.aplicacao.unitarios.validacao;

import com.acme.aplicacao.casos.validacao.UC_ValidaCliente;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ValidaClienteTest {

    private final IClienteRepositorio repositorio = Mockito.mock(IClienteRepositorio.class);
    private final UC_ValidaCliente service = new UC_ValidaCliente(repositorio);

    @Test
    void validaClienteExistente() {
        Mockito.when(repositorio.existeClientePorNumero(1)).thenReturn(true);
        assertTrue(service.executarUC(1));
    }

    @Test
    void validaClienteInexistente() {
        Mockito.when(repositorio.existeClientePorNumero(2)).thenReturn(false);
        assertFalse(service.executarUC(2));
    }
}