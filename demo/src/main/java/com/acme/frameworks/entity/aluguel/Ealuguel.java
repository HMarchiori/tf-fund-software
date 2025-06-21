package com.acme.frameworks.entity.aluguel;
import com.acme.frameworks.entity.jogo.Ejogo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import lombok.*;


@NoArgsConstructor
@Data
@Entity
public class Ealuguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private LocalDateTime Date;
    private Integer periodo;
    @OneToOne
    @JoinColumn(name = "codigo")
    private Ejogo jogo;


}
