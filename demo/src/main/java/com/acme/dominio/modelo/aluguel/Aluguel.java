package com.acme.dominio.modelo.aluguel;

import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.jogo.Jogo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Aluguel {
    private Integer identificador;
    private LocalDateTime dataInicial;
    private Integer periodo;
    private Cliente cliente; 
    private Jogo jogo;
}
