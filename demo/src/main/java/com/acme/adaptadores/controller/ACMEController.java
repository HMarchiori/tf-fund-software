package com.acme.adaptadores.controller;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.cadastro.UC_CadastraJogo;
import com.acme.aplicacao.casos.cadastro.UC_CadastroCliente;
import com.acme.aplicacao.casos.lista.UC_ListaJogos;
import com.acme.aplicacao.casos.validacao.UC_ValidaJogo;
import com.acme.dominio.modelo.cliente.Cliente;
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
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        // amigo, o que precisa ser feito aqui é converter o DTO para o domínio
        // dá para criar uma classe Mapper!! só copiar o que tá no JogoMapper.
        // qualquer coisa estou sempre aqui hehehe
        // TODO: vou deixar um placeholder ok>
        Cliente cliente = new Cliente(clienteDTO.getNumero(), clienteDTO.getNome(), clienteDTO.getEndereco());
        cadastroCliente.executarUC(cliente);
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
