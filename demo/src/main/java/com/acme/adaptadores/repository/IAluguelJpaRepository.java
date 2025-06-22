package com.acme.adaptadores.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.acme.frameworks.entity.aluguel.Ealuguel;

public interface IAluguelJpaRepository extends CrudRepository<Ealuguel, Integer> {
    Ealuguel save(Ealuguel aluguel); 
    List<Ealuguel> findAll();  
    Optional<Ealuguel> findById(Integer id);

}