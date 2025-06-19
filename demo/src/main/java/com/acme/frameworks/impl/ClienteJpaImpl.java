package com.acme.frameworks.impl;

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
                // ISSO É UM PLACEHOLDER
                // TODO: Implementar o mapper, só olhar o que eu fiz e copiar!
                .map(clienteEntity -> new Cliente(clienteEntity.getNumero(), clienteEntity.getNome(), clienteEntity.getEndereco()))
                .toList();
    }

    @Override
    public Cliente getClienteByNumero(Integer id) {
        return null;
    }

    @Override
    public void salvarCliente(Cliente cliente) {

    }

    @Override
    public boolean existeClientePorNumero(Integer id) {
        return false;
    }
}
