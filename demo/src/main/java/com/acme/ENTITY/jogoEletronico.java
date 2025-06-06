package com.acme.ENTITY;


import lombok.Data;
import com.acme.enumerates.tipoEletronico;


import jakarta.persistence.Entity;


@Data
@Entity
public class jogoEletronico {
    private tipoEletronico tipo;
    private String plataforma;
}
