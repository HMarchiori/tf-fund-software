package com.acme.dominio.servico;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.JogoMesa;

public class CalculoPrecoAluguel {

    public static double calcular(Aluguel aluguel) {
        double precoJogo = CalculoPrecoJogo.calcular(aluguel.getJogo());
        Cliente cliente = aluguel.getCliente();

        if (cliente instanceof ClienteIndividual) {
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

    public static double calcularPrecoEmpresa(double precoJogo, int periodo, Jogo jogo) {
        if (precoJogo <= 0 || jogo == null) {
            throw new IllegalArgumentException("Preço do jogo deve ser maior que zero.");
        }
        if (jogo instanceof JogoEletronico) return precoJogo * periodo;
        else if (jogo instanceof JogoMesa) return  0.85 * (precoJogo * periodo);
        return precoJogo * periodo;
    }

}