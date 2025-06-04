package com.acme.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//Importar lombok para usar @Getter e @Setter


@Entity
@Table(name = "individual")
public class EIndividual {
    //Definir o tipo  de chave.
    @Column(name = "cpf")
    private String cpf;

}
