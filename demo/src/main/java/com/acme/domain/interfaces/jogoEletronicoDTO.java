package com.acme.domain.interfaces;

import com.acme.enumerates.tipoEletronico;

public record jogoEletronicoDTO(String nome, Double valorBase,tipoEletronico tipo, String plataforma) {

}
