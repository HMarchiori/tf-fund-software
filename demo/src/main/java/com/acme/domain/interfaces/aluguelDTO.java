package com.acme.domain.interfaces;

import java.time.LocalDateTime;


public record aluguelDTO(Integer idenficador, LocalDateTime dataInicio, int periodo) {
}
