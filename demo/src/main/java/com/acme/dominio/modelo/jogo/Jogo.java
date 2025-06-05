package com.acme.dominio.modelo.jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Jogo {

    protected int codigo;
    protected String nome;
    protected double valorBase;

}
