package com.acme.frameworks.impl;

import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.repository.IClienteJpaRepository;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteJpaImpl implements IClienteRepositorio {

    private final IClienteJpaRepository repository;

    public ClienteJpaImpl(IClienteJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Cliente> getClientes() {
        return repository.findAll().stream()
                .map(ClienteMapper::toDomain)
                .toList();
    }

    @Override
    public Cliente getClienteByNumero(Integer numero) {
        var clienteEntity = repository.findByNumero(numero);
        return ClienteMapper.toDomain(clienteEntity);
    }

    @Override
    public void salvarCliente(Cliente cliente) {
        var clienteEntity = ClienteMapper.toEntity(cliente);
        repository.save(clienteEntity);
    }

    @Override
    public boolean existeClientePorNumero(Integer numero) {
        var clienteEntity = repository.findByNumero(numero);
        return clienteEntity != null;
    }
}
