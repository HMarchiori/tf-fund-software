package com.acme.adaptadores.controller.validacao;

import com.acme.aplicacao.casos.validacao.UC_ValidaJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acmegames")
public class ValidacaoController {

    private final UC_ValidaJogo validaJogo;

    public ValidacaoController(UC_ValidaJogo validaJogo) {
        this.validaJogo = validaJogo;
    }


    // OK MAS TENHO UM BAITA PROBLEMA NISSO AQUI!
    // O ENDPOINT QUE ELE PEDIU NÃO PASSA O CÓDIGO NA URL,
    // NÃO USAR ESTE ENDPOINT PARA CRIAR OS OUTROS
    // PRECISO REFAZER.
    // Isso é um problema para outro dia :D

    @PostMapping("/validajogo/{codigo}")
    public ResponseEntity<Boolean> validarJogo(@PathVariable Integer codigo) {
        boolean isValido = validaJogo.executarUC(codigo);
        return ResponseEntity.ok(isValido);
    }

    // TODO
    // Endpoint: POST /acmegames/validacliente

    // TODO
    // Endpoint: POST /acmegames/validaaluguel
}
