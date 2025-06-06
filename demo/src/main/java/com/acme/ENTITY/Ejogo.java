package com.acme.ENTITY;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Ejogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valorBase")
    private Double valorBase;
    //Jogo de mesa
    @OneToOne
    @JoinColumn(name="tipo")
    private jogoMesa mesa;
    //Jogo eletronico
    @OneToOne
    @JoinColumn(name="tipo")
    private jogoEletronico eletronico;

}
