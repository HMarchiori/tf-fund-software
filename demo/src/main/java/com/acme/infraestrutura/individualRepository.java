package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.Eindividual;

public interface individualRepository extends JpaRepository <Eindividual, String> {

}
