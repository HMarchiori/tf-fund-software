package com.acme.domain;
import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ealuguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private LocalDateTime dataInicio;
    private int periodo;
    //Join na coluna cliente
    @JoinColumn(name = "id")
    @ManyToOne
    private ECliente cliente;
    //Join na coluna jogo   
    @JoinColumn(name = "codigo") 
    @ManyToOne
    private Ejogo jogo;
}
