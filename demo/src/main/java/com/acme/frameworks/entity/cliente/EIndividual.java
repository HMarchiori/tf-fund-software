package com.acme.frameworks.entity.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("INDIVIDUAL")
public class EIndividual extends ECliente {

    @Column(name = "cpf")
    private String cpf;
}