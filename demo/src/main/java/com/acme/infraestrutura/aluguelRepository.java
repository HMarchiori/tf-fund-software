package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.Ealuguel;

public interface aluguelRepository extends JpaRepository<Ealuguel, Integer> {

}
