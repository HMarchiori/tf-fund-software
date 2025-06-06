package com.acme.DTO;

import java.time.LocalDateTime;


public record aluguelDTO(Integer idenficador, LocalDateTime dataInicio, int periodo) {
}
