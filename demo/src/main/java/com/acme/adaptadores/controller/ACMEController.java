package com.acme.adaptadores.controller;

import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.UC_ListaJogos;
import com.acme.aplicacao.casos.UC_ValidaJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ACMEController {

    private final UC_ListaJogos listaJogos;
    private final UC_ValidaJogo validaJogo;

    public ACMEController(UC_ListaJogos listaJogos, UC_ValidaJogo validaJogo) {
        this.listaJogos = listaJogos;
        this.validaJogo = validaJogo;
    }

    @GetMapping("/listajogos")
    public ResponseEntity<List<JogoDTO>> listarJogos() {
        List<JogoDTO> jogos = listaJogos.listarJogos().stream()
                .map(JogoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/validajogo/{codigo}")
    public ResponseEntity<Boolean> validarJogo(@PathVariable Integer codigo) {
        boolean isValido = validaJogo.validarJogo(codigo);
        return ResponseEntity.ok(isValido);
    }

}
