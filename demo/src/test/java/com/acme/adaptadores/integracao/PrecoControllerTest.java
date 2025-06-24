package com.acme.adaptadores.integracao;

import com.acme.adaptadores.controller.aluguel.PrecoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PrecoControllerTest {

    @Autowired
    private PrecoController precoController;



    @Test
    void calculaValorDoJogo() {
        ResponseEntity<Double> response = precoController.valorJogo(2);
        assertNotNull(response.getBody());
        System.out.println("Valor do jogo: " + response.getBody());
        assertEquals(138.0, response.getBody(), 0);
    }

    @Test
    void calculaValorFinalDoAluguel() {
        ResponseEntity<Double> response = precoController.valorFinal(2);
        assertNotNull(response.getBody());
        assertEquals(1380.0, response.getBody(), 0.01);
    }
}