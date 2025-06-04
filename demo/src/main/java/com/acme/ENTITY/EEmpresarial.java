package com.acme.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "empresarial")
public class EEmpresarial {
    //Definir o tipo de chave 
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "razao_social")
    private String razaoSocial;


}
