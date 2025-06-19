package com.acme.frameworks.entity.jogo;

import com.acme.dominio.modelo.jogo.structures.TipoEletronico;
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
@DiscriminatorValue("eletronico")
public class EJogoEletronico extends EJogo {

    @Enumerated(EnumType.STRING)
    private TipoEletronico tipo;

    private String plataforma;
}