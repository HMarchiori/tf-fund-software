package com.acme.adaptadores.controller.aluguel;

import com.acme.aplicacao.casos.preco.UC_CalculaValorAluguel;
import com.acme.aplicacao.casos.preco.UC_CalculaValorJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmegames/aluguel")
public class PrecoController {

    private final UC_CalculaValorJogo calculaValorJogo;
    private final UC_CalculaValorAluguel calculaValorAluguel;

    public PrecoController(UC_CalculaValorJogo calculaValorJogo, UC_CalculaValorAluguel calculaValorAluguel) {
        this.calculaValorJogo = calculaValorJogo;
        this.calculaValorAluguel = calculaValorAluguel;
    }

    @GetMapping("/valorjogo/{codigo}")
    public ResponseEntity<Double> valorJogo(@PathVariable Integer codigo) {
        double valor = calculaValorJogo.executarUC(codigo);
        return ResponseEntity.ok(valor);
    }

    @GetMapping("/valorfinal/{identificador}")
    public ResponseEntity<Double> valorFinal(@PathVariable Integer identificador) {
        double valor = calculaValorAluguel.executarUC(identificador);
        return ResponseEntity.ok(valor);
    }

}
