package com.acme.aplicacao.casos.cadastro;

import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UC_CadastroCliente {
    private final com.acme.dominio.persistencia.IClienteRepositorio clienteRepositorio;

    public UC_CadastroCliente(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;

    }

    public void executarUC(Cliente cliente) {
        clienteRepositorio.salvarCliente(cliente);
    }

}

