package com.acme.adaptadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.dominio.persistencia.IClienteRepositorio;
import com.acme.frameworks.entity.EJogo;

public interface IjogoJpaRepository extends JpaRepository<EJogo, Integer>, IClienteRepositorio {

}
