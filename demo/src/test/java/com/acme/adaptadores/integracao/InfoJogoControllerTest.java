package com.acme.adaptadores.integracao;

import com.acme.adaptadores.controller.info.InfoJogoController;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InfoJogoControllerTest {

    @Autowired
    private InfoJogoController controller;

    @Test
    void retornaAlugueisDoCliente() {
        ResponseEntity<List<AluguelDTO>> response = controller.alugueisDoCliente("1");
        List<AluguelDTO> alugueis = response.getBody();
        assertNotNull(alugueis);
        assertFalse(alugueis.isEmpty());
        boolean contains = alugueis.stream().anyMatch(a -> a.getIdentificador() == 1);
        assertTrue(contains);
    }

    @Test
    void retornaAlugueisDoJogo() {
        ResponseEntity<List<AluguelDTO>> response = controller.alugueisDoJogo("1");
        List<AluguelDTO> alugueis = response.getBody();
        assertNotNull(alugueis);
        assertFalse(alugueis.isEmpty());
        boolean contains = alugueis.stream().anyMatch(a -> a.getIdentificador() == 1);
        assertTrue(contains);
    }
}