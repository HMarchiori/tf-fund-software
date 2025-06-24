package com.acme.aplicacao.unitarios.lista;

import com.acme.aplicacao.casos.lista.UC_ListaJogos;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListaJogosTest {

    private final IJogoRepositorio repositorio = Mockito.mock(IJogoRepositorio.class);
    private final UC_ListaJogos service = new UC_ListaJogos(repositorio);

    @Test
    void deveListarJogos() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA", 100.0, TipoEletronico.AVENTURA, "PC");
        Mockito.when(repositorio.getJogos()).thenReturn(List.of(jogo));

        List<Jogo> result = service.executarUC();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(jogo, result.get(0));
    }
}