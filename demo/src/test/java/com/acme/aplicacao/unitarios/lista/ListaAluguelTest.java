package com.acme.aplicacao.unitarios.lista;

import com.acme.aplicacao.casos.lista.UC_ListaAluguel;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaAluguelTest {

    private final IAluguelRepositorio repositorio = Mockito.mock(IAluguelRepositorio.class);
    private final UC_ListaAluguel service = new UC_ListaAluguel(repositorio);

    @Test
    void deveListarAlugueis() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua", "000.000.000-00");
        Aluguel aluguel = new Aluguel(1, new Date(), 3, jogo, cliente);
        Mockito.when(repositorio.getAlugueis()).thenReturn(List.of(aluguel));

        List<Aluguel> result = service.executarUC();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(aluguel, result.get(0));
    }
}