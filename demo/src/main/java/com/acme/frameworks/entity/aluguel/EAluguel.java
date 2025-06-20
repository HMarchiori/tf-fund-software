package com.acme.frameworks.entity.aluguel;

import com.acme.frameworks.entity.cliente.ECliente;
import com.acme.frameworks.entity.jogo.EJogo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluguel")
public class EAluguel {

    @Id
    private int identificador;

    @Column(name = "data_inicial")
    private Date dataInicial;

    private int periodo;

    @ManyToOne
    @JoinColumn(name = "jogo_codigo")
    private EJogo jogo;

    @ManyToOne
    @JoinColumn(name = "cliente_numero")
    private ECliente cliente;
}