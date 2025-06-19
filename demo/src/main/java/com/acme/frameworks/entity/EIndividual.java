package com.acme.frameworks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("INDIVIDUAL")
public class EIndividual extends ECliente {

    @Column(name = "cpf")
    private String cpf;
}