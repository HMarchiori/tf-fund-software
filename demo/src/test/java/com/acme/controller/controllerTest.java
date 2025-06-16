package com.acme.controller;

import com.acme.ENTITY.Ejogo;
import com.acme.JPA.jogoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class controllerTest {

    @Mock
    private jogoRepository jogoRepo;

    @InjectMocks
    private controller controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validaJogoExistente() {
        // Given
        int codigoExistente = 1;
        when(jogoRepo.existsById(codigoExistente)).thenReturn(true);

        // When
        boolean resultado = controller.validaJogo(String.valueOf(codigoExistente));

        // Then
        assertTrue(resultado);
        verify(jogoRepo).existsById(codigoExistente);
    }

    @Test
    void validaJogoInexistente() {
        // Given
        int codigoInexistente = 999;
        when(jogoRepo.existsById(codigoInexistente)).thenReturn(false);

        // When
        boolean resultado = controller.validaJogo(String.valueOf(codigoInexistente));

        // Then
        assertFalse(resultado);
        verify(jogoRepo).existsById(codigoInexistente);
    }

    @Test
    void deveRetornarLista() {
        // Given
        Ejogo jogo1 = new Ejogo() {{
            setCodigo(1);
            setNome("LoL");
            setValorBase(299.99);
        }};
        Ejogo jogo2 = new Ejogo() {{
            setCodigo(2);
            setNome("Digital Dynasty");
            setValorBase(599.99);
        }};

        List<Ejogo> jogosMock = Arrays.asList(jogo1, jogo2);
        when(jogoRepo.findAll()).thenReturn(jogosMock);

        // When
        List<Ejogo> resultado = controller.getJogos();

        // Then
        assertEquals(2, resultado.size());
        assertEquals("LoL", resultado.get(0).getNome());
        verify(jogoRepo).findAll();
    }
}