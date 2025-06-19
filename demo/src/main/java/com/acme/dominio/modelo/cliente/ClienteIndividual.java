package com.acme.dominio.modelo.cliente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteIndividual extends Cliente {
    private String cpf;

    public ClienteIndividual(int numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }
}
