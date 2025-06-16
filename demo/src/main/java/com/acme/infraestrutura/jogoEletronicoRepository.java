package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.EjogoEletronico;


public interface jogoEletronicoRepository extends JpaRepository<EjogoEletronico, Integer> {


}