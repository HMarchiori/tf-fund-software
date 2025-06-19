package com.acme.aplicacao.casos.validacao;

import com.acme.dominio.persistencia.IClienteRepositorio;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UC_ValidaCliente {

    private final IClienteRepositorio repositorio;

    public UC_ValidaCliente(IClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public boolean executarUC(int numero) {
        return repositorio.existeClientePorNumero(numero);
    }

}
