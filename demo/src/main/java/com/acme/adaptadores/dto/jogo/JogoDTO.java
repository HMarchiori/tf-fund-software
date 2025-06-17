package com.acme.adaptadores.dto.jogo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class JogoDTO {
    protected int codigo;
    protected String nome;
    protected double valorBase;

    public JogoDTO(int codigo, String nome, double valorBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorBase = valorBase;
    }

}