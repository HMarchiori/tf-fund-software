package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.EjogoMesa;



public interface JogoMesaRepository extends JpaRepository<EjogoMesa, Integer>{

}
