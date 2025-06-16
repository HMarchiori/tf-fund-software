package com.acme.frameworks.entity;


import com.acme.dominio.modelo.jogo.structures.TipoMesa;
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
public class EJogoMesa extends EJogo {
    @Enumerated(EnumType.STRING)
    private TipoMesa tipo;
    private Integer numeroPecas;
}

