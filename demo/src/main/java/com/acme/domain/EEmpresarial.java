package com.acme.domain;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name = "empresarial")
public class EEmpresarial extends ECliente {
    @Id
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razaoSocial;


}
