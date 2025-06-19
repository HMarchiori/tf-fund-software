package com.acme.aplicacao.casos.validacao;

import com.acme.dominio.persistencia.IJogoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UC_ValidaJogo {
    private final IJogoRepositorio repositorio;

    public UC_ValidaJogo(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public boolean executarUC(int codigo) {
        return repositorio.existeJogoPorId(codigo);
    }

}
