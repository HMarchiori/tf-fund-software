package com.acme.adaptadores.mapper;

import com.acme.adaptadores.dto.cliente.ClienteDTO;
import com.acme.adaptadores.dto.cliente.ClienteEmpresarialDTO;
import com.acme.adaptadores.dto.cliente.ClienteIndividualDTO;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.modelo.cliente.ClienteEmpresarial;
import com.acme.dominio.modelo.cliente.ClienteIndividual;
import com.acme.frameworks.entity.ECliente;
import com.acme.frameworks.entity.EEmpresarial;
import com.acme.frameworks.entity.EIndividual;


public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente instanceof ClienteIndividual individual) {
            return new ClienteIndividualDTO(
                    individual.getNumero(),
                    individual.getNome(),
                    individual.getEndereco(),
                    individual.getCpf()
            );
        } else if (cliente instanceof ClienteEmpresarial empresarial) {
            return new ClienteEmpresarialDTO(
                    empresarial.getNumero(),
                    empresarial.getNome(),
                    empresarial.getEndereco(),
                    empresarial.getCnpj(),
                    empresarial.getNomeFantasia()
            );
        }
        throw new IllegalArgumentException("Tipo de Cliente desconhecido: " + cliente.getClass().getName());
    }

    public static Cliente toDomain(ClienteDTO dto) {
        if (dto instanceof ClienteIndividualDTO individual) {
            return new ClienteIndividual(
                    individual.getNumero(),
                    individual.getNome(),
                    individual.getEndereco(),
                    individual.getCpf()
            );
        } else if (dto instanceof ClienteEmpresarialDTO empresarial) {
            return new ClienteEmpresarial(
                    empresarial.getNumero(),
                    empresarial.getNome(),
                    empresarial.getEndereco(),
                    empresarial.getCnpj(),
                    empresarial.getNomeFantasia()
            );
        }
        throw new IllegalArgumentException("Tipo de ClienteDTO desconhecido: " + dto.getClass().getName());
    }

    public static Cliente toDomain(ECliente entity) {
        if (entity instanceof EIndividual individual) {
            return new ClienteIndividual(
                    individual.getNumero(),
                    individual.getNome(),
                    individual.getEndereco(),
                    individual.getCpf()
            );

        } else if (entity instanceof EEmpresarial empresarial) {
            return new ClienteEmpresarial(
                    empresarial.getNumero(),
                    empresarial.getNome(),
                    empresarial.getEndereco(),
                    empresarial.getCnpj(),
                    empresarial.getNomeFantasia()
            );
        }
        throw new IllegalArgumentException("Tipo de ECliente desconhecido: " + entity.getClass().getName());
    }

    public static ECliente toEntity(Cliente cliente) {
        if (cliente instanceof ClienteIndividual individual) {
            EIndividual entity = new EIndividual();
            entity.setNumero(individual.getNumero());
            entity.setNome(individual.getNome());
            entity.setEndereco(individual.getEndereco());
            entity.setCpf(individual.getCpf());
            return entity;

        } else if (cliente instanceof ClienteEmpresarial empresarial) {
            EEmpresarial entity = new EEmpresarial();
            entity.setNumero(empresarial.getNumero());
            entity.setNome(empresarial.getNome());
            entity.setEndereco(empresarial.getEndereco());
            entity.setCnpj(empresarial.getCnpj());
            entity.setNomeFantasia(empresarial.getNomeFantasia());
            return entity;
        }
        throw new IllegalArgumentException("Tipo de Cliente desconhecido: " + cliente.getClass().getName());
    }

}