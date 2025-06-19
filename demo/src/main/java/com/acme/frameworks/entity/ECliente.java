package com.acme.frameworks.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "cliente")
public class ECliente {


    // número é ID. E é INT.
    // desconsiderar campo ID anterior

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private int numero;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    // imagino que daqui pra frente está ok!!

    @OneToOne
    @JoinColumn(name = "cpf" )
    private Eindividual individual;

    @OneToOne
    @JoinColumn(name = "cnpj")
    private EEmpresarial empresarial;
    



 
}