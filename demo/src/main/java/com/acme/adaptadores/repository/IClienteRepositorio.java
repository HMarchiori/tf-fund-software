package com.acme.adaptadores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.frameworks.entity.*;
import com.acme.frameworks.entity.EJogo;

public interface IClienteRepositorio extends JpaRepository<ECliente, Integer>{

}
