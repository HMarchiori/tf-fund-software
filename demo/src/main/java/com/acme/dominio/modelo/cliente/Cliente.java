package com.acme.dominio.modelo.cliente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cliente {

    private int numero;
    private String nome;
    private String endereco;

    public Cliente(int numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

}
