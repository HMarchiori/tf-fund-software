package com.acme.adaptadores.dto.cliente;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteIndividualDTO extends ClienteDTO {

    private String cpf;

    public ClienteIndividualDTO(int numero, String nome, String endereco, String cpf) {
        super(numero, nome, endereco);
        this.cpf = cpf;
    }
}
