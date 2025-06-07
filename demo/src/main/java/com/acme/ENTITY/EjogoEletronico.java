package com.acme.ENTITY;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.acme.enumerates.tipoEletronico;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("ELETRONICO")
public class EjogoEletronico extends Ejogo {
    @Enumerated(EnumType.STRING)
    private tipoEletronico tipo;
    private String plataforma;
}


