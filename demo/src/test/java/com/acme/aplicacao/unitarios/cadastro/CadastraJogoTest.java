package com.acme.aplicacao.unitarios.cadastro;

import com.acme.aplicacao.casos.cadastro.UC_CadastraJogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CadastraJogoTest {

    private final IJogoRepositorio repositorio = Mockito.mock(IJogoRepositorio.class);
    private final UC_CadastraJogo service = new UC_CadastraJogo(repositorio);

    @Test
    void testCadastraJogoValido() {
        JogoEletronico jogo = new JogoEletronico(1, "FIFA 21", 150.0, TipoEletronico.ESTRATEGIA, "PS4");

        service.executarUC(jogo);

        assertNotNull(jogo);
        assertEquals(1, jogo.getCodigo());
        assertEquals("FIFA 21", jogo.getNome());
        assertEquals(150.0, jogo.getValorBase());
    }
}