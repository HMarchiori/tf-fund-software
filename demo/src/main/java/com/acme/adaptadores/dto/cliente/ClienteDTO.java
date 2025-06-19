package com.acme.adaptadores.dto.cliente;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private final int numero;
    private final String nome;
    private final String endereco;

    public ClienteDTO(int numero, String nome, String endereco) {
        this.numero = numero;
        this.nome = nome;
        this.endereco = endereco;
    }

}
