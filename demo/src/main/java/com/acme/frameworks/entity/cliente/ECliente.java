package com.acme.frameworks.entity.cliente;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente", discriminatorType = DiscriminatorType.STRING)
@Entity
@Table(name = "cliente")
public class ECliente {

    @Id
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

}