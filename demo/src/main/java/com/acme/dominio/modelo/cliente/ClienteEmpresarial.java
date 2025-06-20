package com.acme.dominio.modelo.cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEmpresarial extends Cliente{

    private String nomeFantasia;
    private String cnpj;

    public ClienteEmpresarial(int numero, String nome, String endereco, String cnpj, String nomeFantasia) {
        super(numero, nome, endereco);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }
}
