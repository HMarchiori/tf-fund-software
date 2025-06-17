package com.acme.domain;

import com.acme.domain.Ealuguel;
import com.acme.domain.ECliente;
import com.acme.domain.Eindividual;
import com.acme.domain.Ejogo;
import com.acme.domain.EjogoEletronico;
import com.acme.domain.EjogoMesa;
import com.acme.enumerates.tipoMesa;
import com.acme.enumerates.tipoEletronico;


public class CalculoPrecoAluguel {

    public static double calcular(Ealuguel aluguel) {
        double precoJogo = CalculoPrecoJogo.calcular(aluguel.getJogo());
        ECliente cliente = aluguel.getCliente();

        if (cliente instanceof  Eindividual) {
            return calcularPrecoIndividual(precoJogo, aluguel.getPeriodo());
        } else {
            return calcularPrecoEmpresa(precoJogo, aluguel.getPeriodo(), aluguel.getJogo());
        }
    }


    public static double calcularPrecoIndividual(double precoJogo, int periodo) {
        if (precoJogo <= 0 || periodo <= 0) {
            throw new IllegalArgumentException("Preço do jogo e período devem ser maiores que zero.");
        }
        if (periodo < 7) return 0.9 * (precoJogo * periodo);
        if (periodo <= 14) return 0.8 * (precoJogo * periodo);
        return 0.75 * (precoJogo * periodo);
    }

    public static double calcularPrecoEmpresa(double precoJogo, int periodo, Ejogo jogo) {
        if (precoJogo <= 0 || jogo == null) {
            throw new IllegalArgumentException("Preço do jogo deve ser maior que zero.");
        }
        if (jogo instanceof EjogoEletronico) return precoJogo * periodo;
        else if (jogo instanceof EjogoMesa) return  0.85 * (precoJogo * periodo);
        return precoJogo * periodo;
    }

}
