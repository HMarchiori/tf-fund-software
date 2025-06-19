package com.acme.frameworks.impl;

import com.acme.adaptadores.repository.IJogoJpaRepository;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.adaptadores.mapper.*;
import com.acme.dominio.persistencia.IJogoRepositorio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JogoJpaImpl implements IJogoRepositorio {

    private final IJogoJpaRepository repository;

    public JogoJpaImpl(IJogoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Jogo> getJogos() {
        return repository.findAll().stream()
                .map(JogoMapper::toDomain)
                .toList();
    }

    @Override
    public Jogo getJogoPorId(Integer codigo) {
        var jogoEntity = repository.findByCodigo(codigo);
        return JogoMapper.toDomain(jogoEntity);
    }

    @Override
    public boolean existeJogoPorId(Integer id) {
        var jogoEntity = repository.findByCodigo(id);
        return jogoEntity != null;
    }

    @Override
    public void salvarJogo(Jogo jogo) {
        var jogoEntity = JogoMapper.toEntity(jogo);
        repository.save(jogoEntity);
    }
}