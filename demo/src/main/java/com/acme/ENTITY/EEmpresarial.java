package com.acme.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "empresarial")
public class EEmpresarial {
    @Id
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razaoSocial;


}
