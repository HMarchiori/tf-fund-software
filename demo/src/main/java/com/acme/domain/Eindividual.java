package com.acme.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "individual")
public class Eindividual extends ECliente {
    
    @Id
    @Column(name = "cpf")
    private String cpf;
    
}
 