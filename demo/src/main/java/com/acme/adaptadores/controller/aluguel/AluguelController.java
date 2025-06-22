package com.acme.adaptadores.controller.aluguel;

import com.acme.aplicacao.casos.aluguel.UC_Aluguel;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.frameworks.entity.cliente.ECliente;
import com.acme.frameworks.entity.jogo.EJogo;
import com.acme.adaptadores.repository.IClienteJpaRepository;
import com.acme.adaptadores.repository.IJogoJpaRepository; // supondo que exista

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/acmegames/alugueis")
public class AluguelController {

    private final UC_Aluguel aluguelCasoDeUso;
    private final IJogoJpaRepository jogoRepository; 
    private final IClienteJpaRepository clienteRepository; 

    @Autowired
    public AluguelController(UC_Aluguel aluguelCasoDeUso, IJogoJpaRepository jogoRepository, IClienteJpaRepository clienteRepository) {
        this.aluguelCasoDeUso = aluguelCasoDeUso;
        this.jogoRepository = jogoRepository;
        this.clienteRepository = clienteRepository;
    }
@PostMapping
public ResponseEntity<Void> cadastrarAluguel(@RequestBody AluguelDTO aluguelDTO) {
    if (aluguelDTO.getData() == null) {
        aluguelDTO.setData(LocalDateTime.now());
    }

    EJogo jogoEntity = jogoRepository.findById(aluguelDTO.getCodigoJogo())
        .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

    ECliente clienteEntity = clienteRepository.findById(aluguelDTO.getCodigoCliente())
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    var jogo = JogoMapper.toDomain(jogoEntity);
    var cliente = ClienteMapper.toDomain(clienteEntity);

    Aluguel aluguel = new Aluguel(
        null,
        aluguelDTO.getData(),
        aluguelDTO.getPeriodo(),
        cliente,
        jogo
    );

    aluguelCasoDeUso.cadastrarAluguel(aluguel);
    return ResponseEntity.ok().build();
}
    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        List<Aluguel> alugueis = aluguelCasoDeUso.listarAlugueis();
        return ResponseEntity.ok(alugueis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> obterAluguel(@PathVariable Integer id) {
        Aluguel aluguel = aluguelCasoDeUso.obterPorId(id);
        if (aluguel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluguel);
    }
}
