package com.acme.frameworks.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresarial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EEmpresarial extends ECliente {
    @Id
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
} 
