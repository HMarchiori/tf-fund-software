package com.acme.infraestrutura;
import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.domain.ECliente;

public interface clienteRepository extends JpaRepository<ECliente, Long> {
    

}
