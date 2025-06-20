package com.acme.frameworks.impl;

import com.acme.adaptadores.mapper.ClienteMapper;
import com.acme.adaptadores.repository.IAluguelJpaRepository;
import com.acme.adaptadores.repository.IClienteJpaRepository;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.modelo.cliente.Cliente;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import com.acme.dominio.persistencia.IClienteRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AluguelJpaImpl implements IAluguelRepositorio {

    private final IAluguelJpaRepository repository;


    public AluguelJpaImpl(IAluguelJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Aluguel> getAlugueis() {
        return List.of();
    }

    @Override
    public Aluguel getAluguelByIdentificador(Integer id) {
        return null;
    }

    @Override
    public void salvarAluguel(Aluguel aluguel) {

    }

    @Override
    public boolean existeAluguelPorIdentificador(Integer id) {
        return false;
    }
}
