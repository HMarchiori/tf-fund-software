package com.acme.aplicacao.unitarios.preco;

import com.acme.aplicacao.casos.preco.UC_CalculaValorJogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CalculaValorJogoTest {

    private final IJogoRepositorio repositorio = Mockito.mock(IJogoRepositorio.class);
    private final UC_CalculaValorJogo service = new UC_CalculaValorJogo(repositorio);

    @Test
    void calculaValorDoJogo() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        Mockito.when(repositorio.getJogoPorId(1)).thenReturn(jogo);

        double valor = service.executarUC(1);

        assertEquals(105.0, valor, 0.01);
    }
}