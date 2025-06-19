package com.acme.adaptadores.dto.cliente;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIndividualDTO extends ClienteDTO {

    private final String cpf;

    public ClienteIndividualDTO(int numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }
}
