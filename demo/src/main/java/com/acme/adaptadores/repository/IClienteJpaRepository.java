package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteJpaRepository extends CrudRepository<ECliente, Integer> {
    List<ECliente> findAll();
    ECliente findByNumero(Integer numero);
    ECliente save(ECliente cliente);
}
