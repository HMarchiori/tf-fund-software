package com.acme.adaptadores.dto.aluguel;
import lombok.*;
import java.time.LocalDateTime;

@Data
public class AluguelDTO {
    private LocalDateTime data;
    private int periodo;
    private int codigoJogo;
}
