package com.acme.domain.interfaces;

import com.acme.enumerates.tipoMesa;

public record jogoMesaDTO(String nome, Double valorBase,tipoMesa tipo, Integer numeroPecas) {

}
