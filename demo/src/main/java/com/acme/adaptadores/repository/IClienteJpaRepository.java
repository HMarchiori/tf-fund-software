package com.acme.adaptadores.repository;

import com.acme.frameworks.entity.cliente.ECliente;
import com.acme.frameworks.entity.cliente.EIndividual;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IClienteJpaRepository extends CrudRepository<ECliente, Integer> {
    List<ECliente> findAll();
    ECliente findByNumero(Integer numero);
    ECliente save(ECliente cliente);
    @Query("SELECT e FROM EIndividual e WHERE e.cpf = :cpf")
    Optional<EIndividual> findByCpf(@Param("cpf") String cpf);
}
