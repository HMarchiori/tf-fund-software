package com.acme.adaptadores.controller.validacao;

import com.acme.adaptadores.dto.validate.ValidateAluguelDTO;
import com.acme.adaptadores.dto.validate.ValidateClienteDTO;
import com.acme.adaptadores.dto.validate.ValidateJogoDTO;
import com.acme.aplicacao.casos.validacao.UC_ValidaAluguel;
import com.acme.aplicacao.casos.validacao.UC_ValidaCliente;
import com.acme.aplicacao.casos.validacao.UC_ValidaJogo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acmegames")
public class ValidacaoController {

    private final UC_ValidaJogo validaJogo;
    private final UC_ValidaCliente validaCliente;
    private final UC_ValidaAluguel validaAluguel;

    public ValidacaoController(UC_ValidaJogo validaJogo, UC_ValidaCliente validaCliente, UC_ValidaAluguel validaAluguel) {
        this.validaJogo = validaJogo;
        this.validaCliente = validaCliente;
        this.validaAluguel = validaAluguel;
    }

    @PostMapping("/validajogo")
    public ResponseEntity<Boolean> validarJogo(@RequestBody ValidateJogoDTO dto) {
        boolean isValido = validaJogo.executarUC(dto.codigo());
        return ResponseEntity.ok(isValido);
    }

    @PostMapping("/validacliente")
    public ResponseEntity<Boolean> validarCliente(@RequestBody ValidateClienteDTO dto) {
        boolean isValido = validaCliente.executarUC(dto.numero());
        return ResponseEntity.ok(isValido);
    }

    @PostMapping("/validaaluguel")
    public ResponseEntity<Boolean> validarAluguel(@RequestBody ValidateAluguelDTO dto) {
        boolean isValido = validaAluguel.executarUC(dto.identificador());
        return ResponseEntity.ok(isValido);
    }
}
