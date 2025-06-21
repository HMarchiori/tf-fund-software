package com.acme.adaptadores.mapper;

import java.time.LocalDateTime;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.frameworks.entity.jogo.EJogo;
import com.acme.dominio.modelo.jogo.JogoMesa;
import com.acme.dominio.modelo.jogo.JogoEletronico;
import com.acme.frameworks.entity.jogo.EJogoMesa;
import com.acme.frameworks.entity.jogo.EJogoEletronico;

public class AluguelMapper {

    public static Aluguel toDomain(EJogo entity, LocalDateTime dataInicial, Integer periodo) {
        Jogo jogo = toDomainJogo(entity);
        return new Aluguel(null, dataInicial, periodo, jogo);
    }

    private static Jogo toDomainJogo(EJogo entity) {
        if (entity instanceof EJogoMesa ejogoMesa) {
            return new JogoMesa(ejogoMesa.getCodigo(), ejogoMesa.getNome(), ejogoMesa.getValorBase(), ejogoMesa.getTipo(), ejogoMesa.getNumeroPecas());
        } else if (entity instanceof EJogoEletronico ejogoEletronico) {
            return new JogoEletronico(ejogoEletronico.getCodigo(), ejogoEletronico.getNome(), ejogoEletronico.getValorBase(), ejogoEletronico.getTipo(), ejogoEletronico.getPlataforma());
        }
        throw new IllegalArgumentException("Tipo de jogo desconhecido");
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
        throw new IllegalArgumentException("Tipo de jogo desconhecido");
    }
}
