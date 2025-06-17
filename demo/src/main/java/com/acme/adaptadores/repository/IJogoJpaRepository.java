package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.EJogo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IJogoJpaRepository extends CrudRepository<EJogo, Integer> {
    List<EJogo> findAll();
    EJogo findByCodigo(Integer codigo);
}