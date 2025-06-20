package com.acme.aplicacao.casos.info;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_InfoAluguelCliente {

    private final IAluguelRepositorio repositorio;

    public UC_InfoAluguelCliente(IAluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aluguel> executarUC(int numeroCliente) {
        return repositorio.getAlugueisPorCliente(numeroCliente);
    }
}