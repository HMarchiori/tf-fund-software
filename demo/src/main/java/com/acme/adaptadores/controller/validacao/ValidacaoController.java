package com.acme.adaptadores.controller.validacao;

import com.acme.adaptadores.dto.validate.ValidateClienteDTO;
import com.acme.adaptadores.dto.validate.ValidateJogoDTO;
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

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validarJogo(@RequestBody ValidateJogoDTO dto) {
        boolean isValido = validaJogo.executarUC(dto.codigo());
        return ResponseEntity.ok(isValido);
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validarCliente(@RequestBody ValidateClienteDTO dto) {
        boolean isValido = validaJogo.executarUC(dto.numero());
        return ResponseEntity.ok(isValido);
    }

    // TODO
    // Endpoint: POST /acmegames/validaaluguel
}
