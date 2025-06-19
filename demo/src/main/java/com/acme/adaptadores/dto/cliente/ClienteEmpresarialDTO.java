package com.acme.adaptadores.dto.cliente;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEmpresarialDTO extends ClienteDTO {

    private final String cnpj;
    private final String nomeFantasia;

    public ClienteEmpresarialDTO(int numero, String nome, String endereco, String cnpj, String nomeFantasia) {
        super(numero, nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}
