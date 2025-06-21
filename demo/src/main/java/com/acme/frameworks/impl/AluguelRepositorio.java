package com.acme.frameworks.impl;

import com.acme.dominio.modelo.aluguel.Aluguel;
import com.acme.dominio.persistencia.IAluguelRepositorio;
import com.acme.adaptadores.repository.IAluguelJpaRepository;
import com.acme.adaptadores.mapper.AluguelMapper;
import com.acme.frameworks.entity.aluguel.Ealuguel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AluguelRepositorio implements IAluguelRepositorio {

    private final IAluguelJpaRepository repository;

    @Autowired
    public AluguelRepositorio(IAluguelJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrar(Aluguel aluguel) {
        // Mapear o Aluguel para a entidade Ealuguel
        Ealuguel ealuguel = AluguelMapper.toEntity(aluguel);
        repository.save(ealuguel);  // Salva no banco de dados
    }

    @Override
    public List<Aluguel> todos() {
        // Recupera todos os aluguéis e converte para o modelo de domínio
        return repository.findAll()
                .stream()
                .map(ealuguel -> AluguelMapper.toDomain(ealuguel))  // Mapeia para o domínio
                .collect(Collectors.toList());
    }

    @Override
    public Aluguel porId(Integer id) {
        return repository.findById(id)
                .map(ealuguel -> AluguelMapper.toDomain(ealuguel))  // Mapeia para o domínio
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));  // Lança exceção se não encontrar
    }
}