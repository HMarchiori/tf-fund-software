package com.acme.aplicacao.unitarios.info;

import com.acme.aplicacao.casos.info.UC_InfoAluguelJogo;
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

class InfoAluguelJogoTest {

    private final IAluguelRepositorio repositorio = Mockito.mock(IAluguelRepositorio.class);
    private final UC_InfoAluguelJogo service = new UC_InfoAluguelJogo(repositorio);

    @Test
    void retornaAlugueisDoJogo() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua", "000.000.000-00");
        Aluguel aluguel = new Aluguel(1, new Date(), 3, jogo, cliente);
        Mockito.when(repositorio.getAlugueisPorJogo(1)).thenReturn(List.of(aluguel));

        List<Aluguel> result = service.executarUC(1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(aluguel, result.get(0));
    }
}