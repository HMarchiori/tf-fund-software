package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.Ejogo;

public interface jogoRepository  extends JpaRepository<Ejogo, Integer>{

}
