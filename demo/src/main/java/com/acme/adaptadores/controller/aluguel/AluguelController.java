package com.acme.adaptadores.controller.aluguel;

import com.acme.aplicacao.casos.aluguel.UC_Aluguel;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.mapper.AluguelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmegames/alugueis")
public class AluguelController {

    private final UC_Aluguel aluguelCasoDeUso;

    @Autowired
    public AluguelController(UC_Aluguel aluguelCasoDeUso) {
        this.aluguelCasoDeUso = aluguelCasoDeUso;
    }


    @PostMapping
    public ResponseEntity<Void> cadastrarAluguel(@RequestBody AluguelDTO aluguelDTO) {
        Aluguel aluguel = AluguelMapper.toDomain(aluguelDTO, null);  // Adicione a lógica para recuperar o Jogo aqui.
        aluguelCasoDeUso.cadastrarAluguel(aluguel);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Aluguel>> listarAlugueis() {
        List<Aluguel> alugueis = aluguelCasoDeUso.listarAlugueis();
        return ResponseEntity.ok(alugueis);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> obterAluguel(@PathVariable String id) {
        Aluguel aluguel = aluguelCasoDeUso.obterPorId(id);
        if (aluguel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluguel);
    }
}
