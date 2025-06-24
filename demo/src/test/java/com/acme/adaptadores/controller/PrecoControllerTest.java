package com.acme.adaptadores.controller;

import com.acme.adaptadores.controller.aluguel.PrecoController;
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
        ResponseEntity<Double> response = precoController.valorJogo(1);
        assertNotNull(response.getBody());
        assertEquals(105.0, response.getBody(), 0.01);
    }

    @Test
    void calculaValorFinalDoAluguel() {
        ResponseEntity<Double> response = precoController.valorFinal(1);
        assertNotNull(response.getBody());
        assertEquals(472.5, response.getBody(), 0.01);
    }
}