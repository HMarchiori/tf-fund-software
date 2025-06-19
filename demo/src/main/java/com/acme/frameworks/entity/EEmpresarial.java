package com.acme.frameworks.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresarial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EEmpresarial {
    @Id
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razaoSocial;
} 
