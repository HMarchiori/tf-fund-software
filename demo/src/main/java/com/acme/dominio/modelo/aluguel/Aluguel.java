package com.acme.dominio.modelo.aluguel;

import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.jogo.Jogo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Aluguel {
    private int identificador;
    private Date dataInicial;
    private int periodo;
    private Jogo jogo;
    private Cliente cliente;

    public Aluguel(int identificador, Date dataInicial, int periodo, Jogo jogo, Cliente cliente) {
        this.identificador = identificador;
        this.dataInicial = dataInicial;
        this.periodo = periodo;
        this.jogo = jogo;
        this.cliente = cliente;
    }

}
