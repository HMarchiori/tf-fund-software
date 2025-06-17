package com.acme.adaptadores.controller;

import com.acme.aplicacao.casos.UC_ListaJogos;
import com.acme.aplicacao.casos.UC_ValidaJogo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmegames/cadastro")
public class ACMEController {

    private final UC_ListaJogos listaJogos;
    private final UC_ValidaJogo validaJogo;

    public ACMEController(UC_ListaJogos listaJogos, UC_ValidaJogo validaJogo) {
        this.listaJogos = listaJogos;
        this.validaJogo = validaJogo;
    }


}
