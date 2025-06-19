package com.acme.adaptadores.controller.cadastro;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.cadastro.UC_CadastraJogo;
import com.acme.aplicacao.casos.cadastro.UC_CadastroCliente;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.jogo.Jogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmegames/cadastro")
public class CadastroController {

    private final UC_CadastraJogo cadastraJogo;
    private final UC_CadastroCliente cadastroCliente;

    public CadastroController(UC_CadastraJogo cadastraJogo, UC_CadastroCliente cadastroCliente) {
        this.cadastraJogo = cadastraJogo;
        this.cadastroCliente = cadastroCliente;
    }

    @PostMapping("/cadjogo")
    public ResponseEntity<Void> cadastrarJogo(@RequestBody JogoDTO jogoDTO) {
        Jogo jogo = JogoMapper.toDomain(jogoDTO);
        cadastraJogo.executarUC(jogo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadcliente")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        // amigo, o que precisa ser feito aqui é converter o DTO para o domínio
        // dá para criar uma classe Mapper!! só copiar o que tá no JogoMapper.
        // qualquer coisa estou sempre aqui hehehe
        // TODO: vou deixar um placeholder ok>
        Cliente cliente = new Cliente(clienteDTO.getNumero(), clienteDTO.getNome(), clienteDTO.getEndereco());
        cadastroCliente.executarUC(cliente);
        return ResponseEntity.ok().build();
    }


    // TODO
    // Endpoint: POST /acmegames/cadastro/cadaluguel

}
