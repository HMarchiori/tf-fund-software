package com.acme.frameworks.entity;
import lombok.*;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "individual")
public class Eindividual extends ECliente {
    @Id
    @Column(name = "cpf")
    private String cpf;
}
