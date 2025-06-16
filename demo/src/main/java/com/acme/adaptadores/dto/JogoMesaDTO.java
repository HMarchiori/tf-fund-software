package com.acme.adaptadores.dto;

import com.acme.dominio.modelo.jogo.structures.TipoMesa;

public record JogoMesaDTO(String nome, Double valorBase, TipoMesa tipo, Integer numeroPecas) {

}