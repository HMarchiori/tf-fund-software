package com.acme.adaptadores.controller.cadastro;

import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.lista.UC_ListaJogos;
import com.acme.aplicacao.casos.validacao.UC_ValidaJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ListaController {

    private final UC_ListaJogos listaJogos;

    public ListaController(UC_ListaJogos listaJogos) {
        this.listaJogos = listaJogos;
    }

    @GetMapping("/listajogos")
    public ResponseEntity<List<JogoDTO>> listarJogos() {
        List<JogoDTO> jogos = listaJogos.executarUC().stream()
                .map(JogoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(jogos);
    }

    // TODO
    // Endpoint: GET /acmegames/cadastro/listaclientes

    // TODO
    // Endpoint: GET /acmegames/cadastro/listaalugueis
}
