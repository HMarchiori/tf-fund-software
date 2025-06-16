package com.acme.infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.EEmpresarial;

public interface empresarialRepository extends JpaRepository<EEmpresarial, String> {

}
