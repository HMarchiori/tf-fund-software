package com.acme.aplicacao.unitarios.preco;

import com.acme.aplicacao.casos.preco.UC_CalculaValorAluguel;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CalculaValorAluguelTest {

    private final IAluguelRepositorio repositorio = Mockito.mock(IAluguelRepositorio.class);
    private final UC_CalculaValorAluguel service = new UC_CalculaValorAluguel(repositorio);

    @Test
    void calculaValorAluguelValido() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua", "000.000.000-00");
        Aluguel aluguel = new Aluguel(1, new Date(), 5, jogo, cliente);
        Mockito.when(repositorio.getAluguelByIdentificador(1)).thenReturn(aluguel);

        double valor = service.executarUC(1);

        assertEquals(472.5, valor, 0.01);
    }

    @Test
    void calculaValorAluguelInvalido() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        ClienteIndividual cliente = new ClienteIndividual(1, "Maria", "Rua", "000.000.000-00");
        Aluguel aluguel = new Aluguel(1, new Date(), 0, jogo, cliente);
        Mockito.when(repositorio.getAluguelByIdentificador(1)).thenReturn(aluguel);

        assertThrows(IllegalArgumentException.class, () -> service.executarUC(1));
    }
}