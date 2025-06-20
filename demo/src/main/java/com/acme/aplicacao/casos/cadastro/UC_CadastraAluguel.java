package com.acme.aplicacao.casos.cadastro;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UC_CadastraAluguel {
    private final IAluguelRepositorio repositorio;

    public UC_CadastraAluguel(IAluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void executarUC(Aluguel aluguel) {
        repositorio.salvarAluguel(aluguel);
    }
}