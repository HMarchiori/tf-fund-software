package com.acme.dominio.modelo.aluguel;

import com.acme.dominio.modelo.jogo.Jogo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Aluguel {
    private Integer identificador;
    private LocalDateTime dataInicial;
    private Integer periodo;
    private Jogo jogo;  

    // Construtor, getters e setters
    public Aluguel(Integer identificador, LocalDateTime dataInicial, Integer periodo, Jogo jogo) {
        this.identificador = identificador;
        this.dataInicial = dataInicial;
        this.periodo = periodo;
        this.jogo = jogo;
    }

    
}
