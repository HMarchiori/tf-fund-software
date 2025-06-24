package com.acme.aplicacao.unitarios.cadastro;

import com.acme.aplicacao.casos.cadastro.UC_CadastroCliente;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CadastroClienteTest {

    private final IClienteRepositorio repositorio = Mockito.mock(IClienteRepositorio.class);
    private final UC_CadastroCliente service = new UC_CadastroCliente(repositorio);

    @Test
    void testCadastraClienteValido() {
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua B, 456", "987.654.321-00");

        service.executarUC(cliente);

        assertNotNull(cliente);
        assertEquals(1, cliente.getNumero());
        assertEquals("Maria", cliente.getNome());
        assertEquals("Rua B, 456", cliente.getEndereco());
    }
}