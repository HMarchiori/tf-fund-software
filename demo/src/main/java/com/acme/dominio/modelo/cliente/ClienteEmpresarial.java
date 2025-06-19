package com.acme.dominio.modelo.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEmpresarial extends Cliente{

    private String nomeFantasia;
    private String cnpj;

    public ClienteEmpresarial(int numero, String nome, String endereco, String nomeFantasia, String cnpj) {
        super(numero, nome, endereco);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
}
