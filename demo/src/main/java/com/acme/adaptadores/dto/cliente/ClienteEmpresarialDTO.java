package com.acme.adaptadores.dto.cliente;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClienteEmpresarialDTO extends ClienteDTO {

    private String cnpj;
    private String nomeFantasia;

    public ClienteEmpresarialDTO(int numero, String nome, String endereco, String cnpj, String nomeFantasia) {
        super(numero, nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}
