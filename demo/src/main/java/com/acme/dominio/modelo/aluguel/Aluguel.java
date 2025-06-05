package com.acme.dominio.modelo.aluguel;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Aluguel {
    public int identificador;
    public Date dataInicial;
    public int periodo;

    public Aluguel(int identificador, Date dataInicial, int periodo) {
        this.identificador = identificador;
        this.dataInicial = dataInicial;
        this.periodo = periodo;
    }

}
