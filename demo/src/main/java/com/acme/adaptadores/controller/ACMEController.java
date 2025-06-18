package com.acme.adaptadores.controller;

import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.adaptadores.dto.jogo.*;
import com.acme.aplicacao.casos.UC_CadastraJogo;
import com.acme.aplicacao.casos.UC_CadastroCliente;
import com.acme.aplicacao.casos.UC_ListaJogos;
import com.acme.aplicacao.casos.UC_ValidaJogo;
import com.acme.dominio.modelo.jogo.Jogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/acmegames/cadastro")
public class ACMEController {

    private final UC_ListaJogos listaJogos;
    private final UC_ValidaJogo validaJogo;
    private final UC_CadastraJogo cadastraJogo;
    private final UC_CadastroCliente cadastroCliente;

    public ACMEController(UC_ListaJogos listaJogos, UC_ValidaJogo validaJogo, UC_CadastraJogo cadastraJogo, UC_CadastroCliente cadastroCliente) {
        this.listaJogos = listaJogos;
        this.validaJogo = validaJogo;
        this.cadastraJogo = cadastraJogo;
        this.cadastroCliente = cadastroCliente;
    }

    
    @PostMapping("/cadastracliente")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ) {
        cadastroCliente.executarUC(clienteDTO);
    }


    @GetMapping("/listajogos")
    public ResponseEntity<List<JogoDTO>> listarJogos() {
        List<JogoDTO> jogos = listaJogos.executarUC().stream()
                .map(JogoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/validajogo/{codigo}")
    public ResponseEntity<Boolean> validarJogo(@PathVariable Integer codigo) {
        boolean isValido = validaJogo.executarUC(codigo);
        return ResponseEntity.ok(isValido);
    }

    @PostMapping("/cadastrajogo")
    public ResponseEntity<Void> cadastrarJogo(@RequestBody JogoDTO jogoDTO) {
        Jogo jogo = JogoMapper.toDomain(jogoDTO);
        cadastraJogo.executarUC(jogo);
        return ResponseEntity.ok().build();
    }

}
