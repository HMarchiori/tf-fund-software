package com.acme.frameworks.entity;

import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


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

public class EJogoEletronico extends EJogo {
    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;
    private String plataforma;
}

