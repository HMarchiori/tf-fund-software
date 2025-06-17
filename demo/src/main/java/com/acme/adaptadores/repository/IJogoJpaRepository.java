package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.EJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJogoJpaRepository extends JpaRepository<EJogo, Integer> {

    @Override
    Optional<EJogo> findById(Integer integer);

    boolean existsByCodigo(int codigo);
}