package com.acme.dominio.servico;

import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.JogoMesa;

public class CalculoPrecoJogo {

    public static double calcular(Jogo jogo) {
        if (jogo instanceof JogoEletronico jogoEletronico) {
            return switch (jogoEletronico.getTipo()) {
                case AVENTURA -> jogoEletronico.getValorBase() * 1.05;
                case ESTRATEGIA -> jogoEletronico.getValorBase() * 1.15;
                case SIMULACAO -> jogoEletronico.getValorBase() * 1.25;
            };
        }
        if (jogo instanceof JogoMesa jogoMesa) {
            return switch (jogoMesa.getTipo()) {
                case TABULEIRO -> jogoMesa.getValorBase() * jogoMesa.getNumeroPecas();
                case CARTAS -> jogoMesa.getValorBase() * 1.20;
            };
        }

        return jogo.getValorBase();
    }
}
