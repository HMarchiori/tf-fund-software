package com.acme.ENTITY;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
@Table(name = "individual")
public class Eindividual {
    
    @Id
    @Column(name = "cpf")
    private String cpf;
    
}
 