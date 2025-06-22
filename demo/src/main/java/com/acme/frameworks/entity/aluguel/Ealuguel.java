package com.acme.frameworks.entity.aluguel;

import com.acme.frameworks.entity.cliente.ECliente;
import com.acme.frameworks.entity.jogo.EJogo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "aluguel")
public class Ealuguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private LocalDateTime dataInicial; 
    @NonNull
    private Integer periodo;

    @JoinColumn(name = "numero")
    @ManyToOne
    private ECliente cliente;
    @OneToOne
    @JoinColumn(name = "codigo")
    private EJogo jogo; 
}
