package com.acme.JPA;
import com.acme.ENTITY.ECliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<ECliente, Long> {
    

}
