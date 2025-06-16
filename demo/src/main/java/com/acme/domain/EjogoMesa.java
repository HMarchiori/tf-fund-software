package com.acme.domain;



import com.acme.enumerates.tipoMesa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("MESA")
public class EjogoMesa extends Ejogo {
    @Enumerated(EnumType.STRING)
    private tipoMesa tipo;
    private Integer numeroPecas;
}


