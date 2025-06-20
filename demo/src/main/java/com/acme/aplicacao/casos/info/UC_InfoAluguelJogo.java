package com.acme.aplicacao.casos.info;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_InfoAluguelJogo {

    private final IAluguelRepositorio repositorio;

    public UC_InfoAluguelJogo(IAluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aluguel> executarUC(int codigoJogo) {
        return repositorio.getAlugueisPorJogo(codigoJogo);
    }
}