package com.acme.adaptadores.mapper;

import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.frameworks.entity.aluguel.Ealuguel;
import com.acme.frameworks.entity.cliente.ECliente;
import com.acme.frameworks.entity.jogo.EJogo;

import java.time.LocalDateTime;

public class AluguelMapper {

    // Converte DTO + entidades cliente e jogo para entidade Ealuguel
    public static Ealuguel toEntity(AluguelDTO dto, ECliente cliente, EJogo jogo) {
        Ealuguel entity = new Ealuguel();
        entity.setDataInicial(dto.getData() != null ? dto.getData() : LocalDateTime.now());
        entity.setPeriodo(dto.getPeriodo());
        entity.setCliente(cliente);
        entity.setJogo(jogo);
        return entity;
    }

    // Converte entidade para domínio
    public static Aluguel toDomain(Ealuguel entity) {
        return new Aluguel(
            entity.getIdentificador(), // <-- este campo estava faltando
            entity.getDataInicial(),
            entity.getPeriodo(),
            ClienteMapper.toDomain(entity.getCliente()),
            JogoMapper.toDomain(entity.getJogo())
        );
    }

    // Converte domínio para entidade
    public static Ealuguel toEntity(Aluguel domain) {
        Ealuguel entity = new Ealuguel();
        entity.setIdentificador(domain.getIdentificador());
        entity.setDataInicial(domain.getDataInicial());
        entity.setPeriodo(domain.getPeriodo());
        entity.setCliente(ClienteMapper.toEntity(domain.getCliente()));
        entity.setJogo(JogoMapper.toEntity(domain.getJogo()));
        return entity;
    }
}
