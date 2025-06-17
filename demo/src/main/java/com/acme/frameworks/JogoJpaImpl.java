package com.acme.frameworks;

import com.acme.adaptadores.mapper.JogoMapper;
import com.acme.adaptadores.repository.IJogoJpaRepository;
import com.acme.dominio.modelo.jogo.Jogo;
import com.acme.dominio.persistencia.IJogoRepositorio;
import com.acme.frameworks.entity.EJogo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JogoJpaImpl implements IJogoRepositorio {

    private final IJogoJpaRepository jogoJpaRepository;

    public JogoJpaImpl(IJogoJpaRepository jogoJpaRepository) {
        this.jogoJpaRepository = jogoJpaRepository;
    }

    @Override
    public void cadastrar(Jogo jogo) {
        EJogo entity = JogoMapper.toEntity(jogo);
        jogoJpaRepository.save(entity);
    }

    @Override
    public List<Jogo> buscarTodos() {
        return jogoJpaRepository.findAll().stream()
                .map(JogoMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Jogo> buscarPorCodigo(int codigo) {
        return jogoJpaRepository.findById(codigo)
                .map(JogoMapper::toDomain);
    }

    @Override
    public boolean existsByCodigo(int codigo) {
        return jogoJpaRepository.findById(codigo).isPresent();
    }
}