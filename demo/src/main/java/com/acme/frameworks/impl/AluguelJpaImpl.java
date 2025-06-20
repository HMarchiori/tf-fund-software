package com.acme.frameworks.impl;

import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.adaptadores.repository.IAluguelJpaRepository;
import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
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
        return repository.findAll().stream()
                .map(AluguelMapper::toDomain)
                .toList();
    }

    @Override
    public Aluguel getAluguelByIdentificador(Integer id) {
        var aluguelEntity = repository.findByIdentificador(id);
        return AluguelMapper.toDomain(aluguelEntity);
    }

    @Override
    public void salvarAluguel(Aluguel aluguel) {
        var aluguelEntity = AluguelMapper.toEntity(aluguel);
        repository.save(aluguelEntity);
    }

    @Override
    public boolean existeAluguelPorIdentificador(Integer id) {
        var aluguelEntity = repository.findByIdentificador(id);
        return aluguelEntity != null;
    }
}
