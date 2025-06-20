package com.acme.aplicacao.casos.lista;

import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_ListaCliente {

    public final IClienteRepositorio repositorio;

    public UC_ListaCliente(IClienteRepositorio iClienteRepositorio)  {
        this.repositorio = iClienteRepositorio;
    }

    public List<Cliente> executarUC() {
        return repositorio.getClientes();
    }

}
