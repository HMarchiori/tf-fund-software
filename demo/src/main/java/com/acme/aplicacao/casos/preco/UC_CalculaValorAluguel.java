package com.acme.aplicacao.casos.preco;

import com.acme.dominio.persistencia.IAluguelRepositorio;
import com.acme.dominio.servico.CalculoPrecoAluguel;
import org.springframework.stereotype.Service;

@Service
public class UC_CalculaValorAluguel {

    private final IAluguelRepositorio repositorio;

    public UC_CalculaValorAluguel(IAluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public double executarUC(int identificador) {
        var aluguel = repositorio.getAluguelByIdentificador(identificador);
        return CalculoPrecoAluguel.calcular(aluguel);
    }
}