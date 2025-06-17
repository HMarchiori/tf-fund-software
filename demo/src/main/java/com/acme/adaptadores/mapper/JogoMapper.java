package com.acme.adaptadores.mapper;

import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.dto.jogo.JogoEletronicoDTO;
import com.acme.adaptadores.dto.jogo.JogoMesaDTO;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.JogoMesa;

public class JogoMapper {

    public static Jogo toDomain(JogoDTO dto) {
        if (dto instanceof JogoMesaDTO jogoMesaDTO) {
            return new JogoMesa(
                    jogoMesaDTO.getTipo(),
                    jogoMesaDTO.getNumeroPecas()
            );
        }
        else if (dto instanceof JogoEletronicoDTO jogoEletronicoDTO) {
            return new JogoEletronico(
                    jogoEletronicoDTO.getTipo(),
                    jogoEletronicoDTO.getPlataforma()
            );
        }
        throw new IllegalArgumentException("Tipo de JogoDTO desconhecido: " + dto.getClass().getName());
    }

    public static JogoDTO toDTO(Jogo jogo) {
        if (jogo instanceof JogoMesa jogoMesa) {
            return new JogoMesaDTO(
                    jogo.getCodigo(),
                    jogo.getNome(),
                    jogo.getValorBase(),
                    jogoMesa.getTipo(),
                    jogoMesa.getNumeroPecas()
            );
        }
        else if (jogo instanceof JogoEletronico jogoEletronico) {
            return new JogoEletronicoDTO(
                    jogo.getCodigo(),
                    jogo.getNome(),
                    jogo.getValorBase(),
                    jogoEletronico.getTipo(),
                    jogoEletronico.getPlataforma()
            );
        }
        throw new IllegalArgumentException("Tipo de Jogo desconhecido: " + jogo.getClass().getName());
    }
}
