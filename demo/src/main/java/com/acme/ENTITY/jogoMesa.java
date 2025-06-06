package com.acme.ENTITY;

import com.acme.enumerates.tipoEletronico;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;

@Embeddable
@Data
@Entity
public class jogoMesa {
    private tipoEletronico tipo;
    private int numeroPecas;
}
