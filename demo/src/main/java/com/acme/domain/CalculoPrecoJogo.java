package com.acme.domain;

 


import com.acme.domain.Ejogo;
import com.acme.domain.EjogoEletronico;
import com.acme.domain.EjogoMesa;
import com.acme.enumerates.tipoMesa;
import com.acme.enumerates.tipoEletronico;


public class CalculoPrecoJogo {

    public static double calcular(Ejogo jogo) {
        if (jogo instanceof EjogoEletronico jogoEletronico) {
            return switch (jogoEletronico.getTipo()) {
                case AVENTURA -> jogoEletronico.getValorBase() * 1.05;
                case ESTRATEGIA -> jogoEletronico.getValorBase() * 1.15;
                case SIMULACAO -> jogoEletronico.getValorBase() * 1.25;
            };
        }

        if (jogo instanceof EjogoMesa jogoMesa) {
            return switch (jogoMesa.getTipo()) {
                case TABULEIROS -> jogoMesa.getValorBase() * jogoMesa.getNumeroPecas();
                case CARTAS -> jogoMesa.getValorBase() * 1.20;
            };
        }

        return jogo.getValorBase();
    }
}
