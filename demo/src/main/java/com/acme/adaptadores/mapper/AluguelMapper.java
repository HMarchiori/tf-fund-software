package com.acme.adaptadores.mapper;

import com.acme.adaptadores.dto.aluguel.AluguelDTO;
import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.jogo.JogoDTO;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.frameworks.entity.aluguel.EAluguel;

public class AluguelMapper {

    public static AluguelDTO toDTO(Aluguel aluguel) {
        JogoDTO jogoDTO = JogoMapper.toDTO(aluguel.getJogo());
        ClienteDTO clienteDTO = ClienteMapper.toDTO(aluguel.getCliente());
        return new AluguelDTO(
                aluguel.getIdentificador(),
                aluguel.getDataInicial(),
                aluguel.getPeriodo(),
                jogoDTO,
                clienteDTO
        );
    }

    public static Aluguel toDomain(AluguelDTO dto) {
        return new Aluguel(
                dto.getIdentificador(),
                dto.getDataInicial(),
                dto.getPeriodo(),
                JogoMapper.toDomain(dto.getJogo()),
                ClienteMapper.toDomain(dto.getCliente())
        );
    }

    public static Aluguel toDomain(EAluguel entity) {
        if (entity == null) return null;
        return new Aluguel(
                entity.getIdentificador(),
                entity.getDataInicial(),
                entity.getPeriodo(),
                JogoMapper.toDomain(entity.getJogo()),
                ClienteMapper.toDomain(entity.getCliente())
        );
    }

    public static EAluguel toEntity(Aluguel aluguel) {
        if (aluguel == null) return null;
        EAluguel entity = new EAluguel();
        entity.setIdentificador(aluguel.getIdentificador());
        entity.setDataInicial(aluguel.getDataInicial());
        entity.setPeriodo(aluguel.getPeriodo());
        entity.setJogo(JogoMapper.toEntity(aluguel.getJogo()));
        entity.setCliente(ClienteMapper.toEntity(aluguel.getCliente()));
        return entity;
    }
}