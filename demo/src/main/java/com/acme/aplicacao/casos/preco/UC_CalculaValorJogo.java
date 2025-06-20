package com.acme.aplicacao.casos.preco;

import com.acme.dominio.persistencia.IJogoRepositorio;
import com.acme.dominio.servico.CalculoPrecoJogo;
import org.springframework.stereotype.Service;

@Service
public class UC_CalculaValorJogo {

    private final IJogoRepositorio repositorio;

    public UC_CalculaValorJogo(IJogoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public double executarUC(int codigo) {
        var jogo = repositorio.getJogoPorId(codigo);
        return CalculoPrecoJogo.calcular(jogo);
    }
}