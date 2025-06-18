package com.acme.aplicacao.casos;


@service
public class UC_CadastroCliente {
    private final IClienteRepositorio clienteRepositorio;

    public UC_CadastroCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }
}
