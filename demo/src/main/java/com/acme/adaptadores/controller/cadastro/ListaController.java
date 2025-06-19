package com.acme.adaptadores.controller.cadastro;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.lista.UC_ListaCliente;
import com.acme.aplicacao.casos.lista.UC_ListaJogos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ListaController {

    private final UC_ListaJogos listaJogos;
    private final UC_ListaCliente listaClientes;

    public ListaController(UC_ListaJogos listaJogos, UC_ListaCliente listaClientes) {
        this.listaJogos = listaJogos;
        this.listaClientes = listaClientes;
    }

    @GetMapping("/listajogos")
    public ResponseEntity<List<JogoDTO>> listarJogos() {
        List<JogoDTO> jogos = listaJogos.executarUC().stream()
                .map(JogoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(jogos);
    }

    @GetMapping("/listaclientes")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = listaClientes.executarUC().stream()
                .map(ClienteMapper::toDTO)
                .toList();
        return ResponseEntity.ok(clientes);
    }

    // TODO
    // Endpoint: GET /acmegames/cadastro/listaalugueis
}
