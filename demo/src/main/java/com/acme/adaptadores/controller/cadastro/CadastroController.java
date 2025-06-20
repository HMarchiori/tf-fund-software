package com.acme.adaptadores.controller.cadastro;

import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.aplicacao.casos.cadastro.UC_CadastraAluguel;
import com.acme.aplicacao.casos.cadastro.UC_CadastraJogo;
import com.acme.aplicacao.casos.cadastro.UC_CadastroCliente;
import com.acme.dominio.modelo.aluguel.Aluguel;
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

    private final UC_CadastraJogo cadastroJogo;
    private final UC_CadastroCliente cadastroCliente;
    private final UC_CadastraAluguel cadastroAluguel;

    public CadastroController(UC_CadastraJogo cadastroJogo, UC_CadastroCliente cadastroCliente, UC_CadastraAluguel cadastroAluguel) {
        this.cadastroJogo = cadastroJogo;
        this.cadastroCliente = cadastroCliente;
        this.cadastroAluguel = cadastroAluguel;
    }

    @PostMapping("/cadjogo")
    public ResponseEntity<Void> cadastrarJogo(@RequestBody JogoDTO jogoDTO) {
        Jogo jogo = JogoMapper.toDomain(jogoDTO);
        cadastroJogo.executarUC(jogo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadcliente")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toDomain(clienteDTO);
        cadastroCliente.executarUC(cliente);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadaluguel")
    public ResponseEntity<Void> cadastrarAluguel(@RequestBody AluguelDTO aluguelDTO) {
        Aluguel aluguel = AluguelMapper.toDomain(aluguelDTO);
        cadastroAluguel.executarUC(aluguel);
        return ResponseEntity.ok().build();
    }

}
