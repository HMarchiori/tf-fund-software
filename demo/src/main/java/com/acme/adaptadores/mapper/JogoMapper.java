package com.acme.adaptadores.mapper;

import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.adaptadores.dto.jogo.JogoEletronicoDTO;
import com.acme.adaptadores.dto.jogo.JogoMesaDTO;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.dominio.modelo.jogo.JogoMesa;
import com.acme.frameworks.entity.jogo.EJogo;
import com.acme.frameworks.entity.jogo.EJogoEletronico;
import com.acme.frameworks.entity.jogo.EJogoMesa;

public class JogoMapper {

    public static Jogo toDomain(JogoDTO dto) {
        if (dto instanceof JogoMesaDTO jogoMesaDTO) {
            return new JogoMesa(
                    jogoMesaDTO.getCodigo(),
                    jogoMesaDTO.getNome(),
                    jogoMesaDTO.getValorBase(),
                    jogoMesaDTO.getTipo(),
                    jogoMesaDTO.getNumeroPecas()
            );
        }
        else if (dto instanceof JogoEletronicoDTO jogoEletronicoDTO) {
            return new JogoEletronico(
                    jogoEletronicoDTO.getCodigo(),
                    jogoEletronicoDTO.getNome(),
                    jogoEletronicoDTO.getValorBase(),
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

    public static EJogo toEntity(Jogo jogo) {
        if (jogo instanceof JogoMesa jogoMesa) {
            EJogoMesa entity = new EJogoMesa();
            entity.setCodigo(jogoMesa.getCodigo());
            entity.setNome(jogoMesa.getNome());
            entity.setValorBase(jogoMesa.getValorBase());
            entity.setTipo(jogoMesa.getTipo());
            entity.setNumeroPecas(jogoMesa.getNumeroPecas());
            return entity;
        } else if (jogo instanceof JogoEletronico jogoEletronico) {
            EJogoEletronico entity = new EJogoEletronico();
            entity.setCodigo(jogoEletronico.getCodigo());
            entity.setNome(jogoEletronico.getNome());
            entity.setValorBase(jogoEletronico.getValorBase());
            entity.setTipo(jogoEletronico.getTipo());
            entity.setPlataforma(jogoEletronico.getPlataforma());
            return entity;
        }
        throw new IllegalArgumentException("Tipo de Jogo desconhecido");
    }

    public static Jogo toDomain(EJogo entity) {
        if (entity instanceof EJogoMesa jogoMesa) {
            int numeroPecas = jogoMesa.getNumeroPecas() != null ? jogoMesa.getNumeroPecas() : 0;
            return new JogoMesa(
                    jogoMesa.getCodigo(),
                    jogoMesa.getNome(),
                    jogoMesa.getValorBase(),
                    jogoMesa.getTipo(),
                    numeroPecas
            );

        } else if (entity instanceof EJogoEletronico jogoEletronico) {
            return new JogoEletronico(
                    jogoEletronico.getCodigo(),
                    jogoEletronico.getNome(),
                    jogoEletronico.getValorBase(),
                    jogoEletronico.getTipo(),
                    jogoEletronico.getPlataforma()
            );
        }
        throw new IllegalArgumentException("Tipo de Entity desconhecido");
    }
}
