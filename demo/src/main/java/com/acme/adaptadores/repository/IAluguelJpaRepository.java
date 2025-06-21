package com.acme.adaptadores.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.acme.frameworks.entity.aluguel.Ealuguel;

public interface IAluguelJpaRepository extends CrudRepository<Ealuguel, Integer> {
    Ealuguel save(Ealuguel aluguel); 
    List<Ealuguel> findAll();  
    Ealuguel findById(Integer id);  

}