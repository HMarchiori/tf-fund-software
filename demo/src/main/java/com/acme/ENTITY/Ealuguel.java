package com.acme.ENTITY;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

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
    @JoinColumn(name = "id")
    @ManyToOne
    private ECliente cliente;
}
