package com.acme.frameworks.entity.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoMesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("mesa")
public class EJogoMesa extends EJogo {

    @Enumerated(EnumType.STRING)
    private TipoMesa tipo;


    private Integer numeroPecas;
}