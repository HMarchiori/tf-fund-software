package com.acme.aplicacao.casos.validacao;

import com.acme.dominio.persistencia.IAluguelRepositorio;

public class UC_ValidaAluguel {

    private final IAluguelRepositorio repositorio;


    public UC_ValidaAluguel(IAluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public boolean executarUC(Integer identificador) {
        return repositorio.existeAluguelPorIdentificador(identificador);
    }
}
