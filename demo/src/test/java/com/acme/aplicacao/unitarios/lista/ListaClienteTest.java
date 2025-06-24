package com.acme.aplicacao.unitarios.lista;

import com.acme.aplicacao.casos.lista.UC_ListaCliente;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaClienteTest {

    private final IClienteRepositorio repositorio = Mockito.mock(IClienteRepositorio.class);
    private final UC_ListaCliente service = new UC_ListaCliente(repositorio);

    @Test
    void deveListarClientes() {
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua", "000.000.000-00");
        Mockito.when(repositorio.getClientes()).thenReturn(List.of(cliente));

        List<Cliente> result = service.executarUC();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(cliente, result.get(0));
    }
}