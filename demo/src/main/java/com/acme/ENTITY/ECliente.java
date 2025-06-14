package com.acme.ENTITY;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @OneToOne
    @JoinColumn(name = "cpf" )
    private Eindividual individual;

    @OneToOne
    @JoinColumn(name = "cnpj")
    private EEmpresarial empresarial;
    



 
}
