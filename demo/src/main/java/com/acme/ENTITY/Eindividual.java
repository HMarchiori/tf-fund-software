package com.acme.ENTITY;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "individual")
public class Eindividual {
    
    @Id
    @Column(name = "cpf")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ECliente cliente;
}
