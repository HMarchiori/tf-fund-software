package com.acme.adaptadores.dto.aluguel;
import lombok.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AluguelDTO {
    private LocalDateTime data;
    private int periodo;
    private int codigoJogo;
    private int codigoCliente;


}
