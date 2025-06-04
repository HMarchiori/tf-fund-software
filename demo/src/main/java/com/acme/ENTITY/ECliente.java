package com.acme.ENTITY;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ECliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
private long id;
@Column(name = "nome")
private String nome; 
@Column(name = "endereco")
private String endereco;


}
