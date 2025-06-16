package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.EJogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IJogoJpaRepository extends JpaRepository<EJogo, Long> {
    List<EJogo> todos();
    List<EJogo> porCodigo(long codigo);
}
