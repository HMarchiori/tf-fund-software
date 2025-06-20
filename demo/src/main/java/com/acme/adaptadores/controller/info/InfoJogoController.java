package com.acme.adaptadores.controller.info;

import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.aplicacao.casos.info.UC_InfoAluguelCliente;
import com.acme.aplicacao.casos.info.UC_InfoAluguelJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acmegames")
public class InfoJogoController {

    private final UC_InfoAluguelCliente ucInfoAluguelCliente;
    private final UC_InfoAluguelJogo ucInfoAluguelJogo;


    public InfoJogoController(UC_InfoAluguelCliente ucInfoAluguelCliente, UC_InfoAluguelJogo ucInfoAluguelJogo) {
        this.ucInfoAluguelCliente = ucInfoAluguelCliente;
        this.ucInfoAluguelJogo = ucInfoAluguelJogo;
    }

    @GetMapping("/cliente/aluguel/{numero}")
    public ResponseEntity<List<AluguelDTO>> alugueisDoCliente(@PathVariable Integer numero) {
        List<AluguelDTO> alugueis = ucInfoAluguelCliente.executarUC(numero).stream()
                .map(AluguelMapper::toDTO)
                .toList();
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/jogo/aluguel/{codigo}")
    public ResponseEntity<List<AluguelDTO>> alugueisDoJogo(@PathVariable Integer codigo) {
        List<AluguelDTO> alugueis = ucInfoAluguelJogo.executarUC(codigo).stream()
                .map(AluguelMapper::toDTO)
                .toList();
        return ResponseEntity.ok(alugueis);
    }

}
